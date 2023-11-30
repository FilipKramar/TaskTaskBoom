package com.atos.projektpraksa.project.controller;

import com.atos.projektpraksa.project.dto.ProjectCreationDTO;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.project.service.ProjectService;
import com.atos.projektpraksa.task.dto.TaskListingDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {

        return ResponseEntity.ok(projectService.getAllProjects());
    }
    @PostMapping
    public ResponseEntity<Project> createAProject( @RequestBody ProjectCreationDTO request) {

        return ResponseEntity.ok(projectService.createAProject(request));
    }
}
