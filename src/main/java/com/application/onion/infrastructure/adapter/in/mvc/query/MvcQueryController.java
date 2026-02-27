package com.application.onion.infrastructure.adapter.in.mvc.query;

import com.application.onion.application.dto.UserView;
import com.application.onion.application.port.in.QueryUseCase;
import com.application.onion.infrastructure.adapter.in.common.dto.Mapper;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc/users/search")
public class MvcQueryController {

    private final QueryUseCase service;

    public MvcQueryController(QueryUseCase service) {
        this.service = service;
    }

    @GetMapping("/id")
    public String searchById(@RequestParam String id, Model model) {
        model.addAttribute("response", Mapper.toResponse(service.findById(id)));
        return "result/user-details";
    }

    @GetMapping("/name")
    public String searchByName(@RequestParam String name, Model model) {
        List<UserView> views = service.findByNameStartingWith(name);
        model.addAttribute("searchTerm", name);
        model.addAttribute(
                "userViews", views.stream().map(Mapper::toResponse).toList()
        );
        return "result/list";
    }

}