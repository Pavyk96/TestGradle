package com.pavyk96.TestGradle.hw6.controllers;

import com.pavyk96.TestGradle.hw6.dto.ToDoListRequest;
import com.pavyk96.TestGradle.hw6.dto.ToDoListResponse;
import com.pavyk96.TestGradle.hw6.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final Service service;

    @GetMapping("/todolist")
    public List<ToDoListResponse> getAll() {
        return service.getAll();
    }

    @PostMapping("/todolist")
    public ToDoListResponse getAll(@RequestBody ToDoListRequest request) {
        return service.create(request);
    }

}
