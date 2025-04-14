package com.pavyk96.TestGradle.hw8.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class ApiController {

    @GetMapping("/public/api")
    public String publicApi() {
        return "This is public API. No authentication required.";
    }

    @GetMapping("/admin/api")
    @RolesAllowed("ADMIN")
    public String adminApi(Authentication authentication) {
        return String.format("This is admin API. Authenticated as: %s (Role: %s)",
                authentication.getName(),
                authentication.getAuthorities());
    }

    @GetMapping("/support/api")
    @RolesAllowed("SUPPORT")
    public String supportApi(Authentication authentication) {
        return String.format("This is support API. Authenticated as: %s (Role: %s)",
                authentication.getName(),
                authentication.getAuthorities());
    }
}
