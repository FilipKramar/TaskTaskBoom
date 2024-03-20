package com.atos.projektpraksa.usertask.controller;

import com.atos.projektpraksa.usertask.dto.UserTaskListingDTO;
import com.atos.projektpraksa.usertask.repository.UserTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usertasks")
@AllArgsConstructor
public class UserTaskController {

    private final UserTaskRepository userTaskRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<UserTaskListingDTO>> getAllUserTask (@PathVariable Long id){

        return ResponseEntity.ok(userTaskRepository.findUsersTasks(id));
    }
    @GetMapping
    public ResponseEntity<List<UserTaskListingDTO>> getAllTasks (){

        return ResponseEntity.ok(userTaskRepository.findTasks());
    }

}
