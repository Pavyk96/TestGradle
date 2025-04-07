package com.pavyk96.TestGradle.hw6.service;

import com.pavyk96.TestGradle.hw6.dto.ToDoListRequest;
import com.pavyk96.TestGradle.hw6.dto.ToDoListResponse;

import java.util.List;

public interface Service {
    List<ToDoListResponse> getAll();

    ToDoListResponse create(ToDoListRequest request);
}
