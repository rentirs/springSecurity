package com.rentirs.security.controllers;

import com.rentirs.security.security.PersonDetails;
import com.rentirs.security.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HelloController {

    private AdminService service;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/userinfo")
    public String userinfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        service.doAdminStuff();
        return "admin";
    }
}
