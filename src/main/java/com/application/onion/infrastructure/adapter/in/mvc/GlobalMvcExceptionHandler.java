package com.application.onion.infrastructure.adapter.in.mvc;

import com.application.onion.domain.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.application.onion.infrastructure.adapter.in.mvc")
public class GlobalMvcExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleNotFound(UserNotFoundException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "form/main-page-search";
    }
}