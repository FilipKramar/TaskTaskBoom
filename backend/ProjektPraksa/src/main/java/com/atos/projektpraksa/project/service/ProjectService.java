package com.atos.projektpraksa.project.service;

import com.atos.projektpraksa.enums.Role;
import com.atos.projektpraksa.project.dto.ProjectCreationDTO;
import com.atos.projektpraksa.project.dto.ProjectEditDTO;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.project.repository.ProjectRepository;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import com.atos.projektpraksa.userproject.model.UserProject;
import com.atos.projektpraksa.userproject.repository.UserProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {
     private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private  final UserProjectRepository userProjectRepository;
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
                .users(new ArrayList<>())
                .build();
        projectRepository.save(project);

        return project;
    }
    @Transactional
    public Project editAProject(ProjectEditDTO request) {
        Project project = projectRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + request.getId()));

        project.setDescription(request.getDescription());
        project.setEndDate(request.getEndDate());
        project.setStartDate(request.getStartDate());
        project.setName(request.getName());
        updateUsersInUserProject(project, request.getUsersId());

        return projectRepository.save(project);

    }

    @Transactional
    private void updateUsersInUserProject(Project project, List<Long> newUsers) {
        List<UserProject> existingUserProjects = userProjectRepository.findUserProjectsByProject(project);

        List<User> existingUsers = existingUserProjects.stream()
                .map(UserProject::getUser)
                .collect(Collectors.toList());

        existingUsers.removeAll(newUsers);

        newUsers.forEach(userId -> {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

            if (!existingUsers.contains(user)) {
                UserProject userProject = UserProject.builder()
                        .role(Role.MEMBER)
                        .project(project)
                        .user(user)
                        .build();
                userProjectRepository.save(userProject);


                project.getUsers().add(userProject);
            }
        });

        existingUserProjects.stream()
                .filter(userProject -> !newUsers.contains(userProject.getUser().getId()))
                .forEach(userProject -> {
                    project.getUsers().remove(userProject);
                    userProjectRepository.delete(userProject);
                });
    }





}
