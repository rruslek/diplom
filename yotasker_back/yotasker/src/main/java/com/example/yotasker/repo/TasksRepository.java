package com.example.yotasker.repo;

import com.example.yotasker.dto.Task;
import com.example.yotasker.dto.User;
import com.example.yotasker.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TasksRepository extends JpaRepository<Task, Integer> {
    List<Task> findAll();
    List<Task> findAllByUserAndStatus(User user, TaskStatus status);
}