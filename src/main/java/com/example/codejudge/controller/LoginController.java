package com.example.codejudge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("userId") String userId,
            HttpSession session
    ) {
        if (userId == null || userId.isBlank()) {
            return "redirect:/login";
        }

        session.setAttribute("userId", userId);

        return "redirect:/submit";
    }
}