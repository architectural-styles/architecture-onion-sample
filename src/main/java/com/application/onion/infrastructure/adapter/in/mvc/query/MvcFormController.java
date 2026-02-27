package com.application.onion.infrastructure.adapter.in.mvc.query;

import com.application.onion.application.dto.UserView;
import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.infrastructure.adapter.in.common.dto.CreateUserRequest;
import com.application.onion.infrastructure.adapter.in.common.dto.Mapper;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/users")
public class MvcFormController {

    private final QueryUseCase service;

    public MvcFormController(QueryUseCase service) {
        this.service = service;
    }

    @GetMapping
    public String showSearchForm(
            Model model,
            @ModelAttribute("error") String error,
            @ModelAttribute("message") String message
    ) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        return "form/main-page-search";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("request", new CreateUserRequest("", ""));
        return "form/create-form";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(Model model, @PathVariable String id) {
        model.addAttribute("response", Mapper.toResponse(service.findById(id)));
        return "form/edit-form";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmationForm(@PathVariable String id, Model model) {
        UserView view = service.findById(id);
        model.addAttribute("response", Mapper.toResponse(view));
        return "form/delete-confirm-form";
    }
}