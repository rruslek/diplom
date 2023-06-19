package com.example.yotasker.controllers;

import com.example.yotasker.dto.Task;
import com.example.yotasker.dto.User;
import com.example.yotasker.enums.TaskStatus;
import com.example.yotasker.repo.TasksRepository;
import com.example.yotasker.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins="http://localhost:3000/",
        allowCredentials = "true"
)
public class TasksController {
    @Autowired
    private TasksRepository tasksRepo;

    @GetMapping("/tasks")
    ResponseEntity<Iterable<Task>> getUsers(@RequestParam(value = "status") TaskStatus status, @RequestParam(value = "user") User user) {
        Iterable<Task> tasks = tasksRepo.findAllByUserAndStatus(user, status);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}