package com.pavyk96.TestGradle.hw6.dto;

import com.pavyk96.TestGradle.hw6.models.ToDoItem;
import com.pavyk96.TestGradle.hw6.models.ToDoList;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListResponse {
    private String name;
    private List<String> items;

    public static ToDoListResponse toResponse(ToDoList list) {
        return ToDoListResponse.builder()
                .name(list.getName())
                .items(list.getItems().stream()
                        .map(ToDoItem::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}
