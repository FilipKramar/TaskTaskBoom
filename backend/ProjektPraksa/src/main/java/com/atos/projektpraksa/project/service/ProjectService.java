package com.atos.projektpraksa.project.service;

import com.atos.projektpraksa.project.dto.ProjectCreationDTO;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.project.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
     private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    public Project createAProject(ProjectCreationDTO request) {

        Project project=Project.builder()
                .name(request.getName())
                .endDate(request.getEndDate())
                .startDate(request.getStartDate())
                .description(request.getDescription())
                .userstories(new ArrayList<>())
                .user(new ArrayList<>())
                .build();

        System.out.print(" ovo je projekt" + request);
        projectRepository.save(project);

        return project;
    }
}
