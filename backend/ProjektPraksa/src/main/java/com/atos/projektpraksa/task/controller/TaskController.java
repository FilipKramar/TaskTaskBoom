package com.atos.projektpraksa.task.controller;

import com.atos.projektpraksa.task.dto.*;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.task.service.TaskService;
import com.atos.projektpraksa.usertask.model.UserTask;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping
    public ResponseEntity<List<TaskListingDTO>> getAllTasks() {

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGetDTO> getTask(@PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTask(id));
    }
    @PostMapping
    public ResponseEntity<Task> createANewTask(@RequestBody TaskCreationDTO taskCreationDTO) {

        return ResponseEntity.ok(taskService.createANewTask(taskCreationDTO));

    }

    @PatchMapping
    public ResponseEntity<UserTask> editTaskAssignee(@RequestBody TaskEditAssigneeDTO request) {

        return ResponseEntity.ok(taskService.editTaskAssignee(request));
    }

    @PutMapping
    public  ResponseEntity<Task> editTask(@RequestBody TaskEditDTO request ){

        return ResponseEntity.ok(taskService.editTask(request));
    }
    @GetMapping("/test")
    public  ResponseEntity<Task> Test(){

        return ResponseEntity.ok(taskService.test());
    }

}
