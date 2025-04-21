package com.pavyk96.TestGradle.hw9.controller;

import com.pavyk96.TestGradle.hw9.dto.EventRequest;
import com.pavyk96.TestGradle.hw9.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {
    private final EventService eventService;

    @PostMapping("/regular")
    public String fireRegularEvent(@RequestBody EventRequest request) {
        eventService.publishRegularEvent(request);
        return "Regular event published: " + request.message();
    }

    @PostMapping("/async")
    public String fireAsyncEvent(@RequestBody EventRequest request) {
        eventService.publishAsyncEvent(request);
        return "Async event published: " + request.message();
    }

    @PostMapping("/transactional")
    @Transactional
    public String fireTransactionalEvent(@RequestBody EventRequest request) {
        eventService.publishTransactionalEvent(request);
        return "Transactional events published: " + request.message();
    }
}
