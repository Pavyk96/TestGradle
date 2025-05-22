package com.pavyk96.TestGradle.hw10.controller;


import com.pavyk96.TestGradle.hw10.annotation.RateLimited;
import com.pavyk96.TestGradle.hw10.dto.MessageResponse;
import com.pavyk96.TestGradle.hw10.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RateLimited
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @RateLimited
    @GetMapping("/message")
    public MessageResponse getMessage() {
        return messageService.getMessage();
    }

    @PostMapping("/refresh")
    public Map<String, String> refreshLimit() {
        messageService.reset();
        return Map.of("message", "Лимит запросов успешно сброшен");
    }
}
