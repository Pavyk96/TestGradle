package com.pavyk96.TestGradle.hw6.dto;

import com.pavyk96.TestGradle.hw6.models.ToDoItem;
import com.pavyk96.TestGradle.hw6.models.ToDoList;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListRequest {
    private String name;
    private List<String> events;

    public static ToDoList toModel(ToDoListRequest request) {
        ToDoList list = ToDoList.builder()
                .name(request.name)
                .items(new ArrayList<>())
                .build();

        request.events.forEach(itemText -> {
            ToDoItem item = ToDoItem.builder()
                    .name(itemText)
                    .list(list)
                    .build();
            list.getItems().add(item);
        });

        return list;
    }
}
