package com.example.sec.controller;

import com.example.sec.model.User;
import com.example.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PreAuthorize("isAnonymous()")
    @PostMapping(value = "/register")
    public String addUser(User user,@RequestParam String rePassword){
        String result =  userService.addUser(user, rePassword);
        return "redirect:/sign-in?" + result;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/change-password")
    public String changePassword(@RequestParam String currentPassword,
                                 @RequestParam String newPassword,
                                 @RequestParam String reNewPassword){
    String result = userService.changePassword(currentPassword, newPassword, reNewPassword);
        return "redirect:/?" + result ;
    }
}
