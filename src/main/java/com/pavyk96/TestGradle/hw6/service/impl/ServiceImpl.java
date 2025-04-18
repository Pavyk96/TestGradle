package com.pavyk96.TestGradle.hw6.service.impl;

import com.pavyk96.TestGradle.hw6.dto.ToDoListRequest;
import com.pavyk96.TestGradle.hw6.dto.ToDoListResponse;
import com.pavyk96.TestGradle.hw6.models.ToDoList;
import com.pavyk96.TestGradle.hw6.repo.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements com.pavyk96.TestGradle.hw6.service.Service {

    private final Repository repository;

    @Override
    public List<ToDoListResponse> getAll() {
        return repository.findAll().stream()
                .map(ToDoListResponse::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ToDoListResponse create(ToDoListRequest request) {
        ToDoList savedList = repository.save(ToDoListRequest.toModel(request));
        return ToDoListResponse.toResponse(savedList);
    }
}
