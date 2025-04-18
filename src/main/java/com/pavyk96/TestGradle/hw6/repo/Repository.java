package com.pavyk96.TestGradle.hw6.repo;

import com.pavyk96.TestGradle.hw6.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<ToDoList, String> {
}
