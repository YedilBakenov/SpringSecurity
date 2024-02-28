package com.example.sec.controller;

import com.example.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/")
    public String mainPage(){
        System.out.println(userService.getCurrentUser().getFullName());
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in")
    public String signIn(){
        return "sign-in";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage(){
        return "admin-page";
    }

    @GetMapping(value = "/forbidden")
    public String forbiddenPage(){
        return "forbidden";
    }
}
