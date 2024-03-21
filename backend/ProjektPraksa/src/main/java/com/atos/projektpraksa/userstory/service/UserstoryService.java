package com.atos.projektpraksa.userstory.service;

import com.atos.projektpraksa.task.dto.TaskGetDTO;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.task.service.TaskService;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import com.atos.projektpraksa.userstory.dto.*;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.atos.projektpraksa.userstory.repository.UserStoryRepository;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import com.atos.projektpraksa.useruserstory.repository.UserUserstoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serial;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserstoryService {

    private final UserStoryRepository userStoryRepository;
    private final UserUserstoryRepository userUserstoryRepository;
    private final UserRepository userRepository;
    private final TaskService taskService;
    public List<UserstoryListingDTO> getAllUserstories() {

        List<Userstory> userstories=userStoryRepository.findAll();

        List<UserstoryListingDTO> listedUserstories=new ArrayList<>();

        for(Userstory userstory:userstories){
            if(userstory.getAssignee()!=null){

                UserstoryListingDTO userstoryListingDTO= UserstoryListingDTO.builder()
                        .id(userstory.getId())
                        .name(userstory.getName())
                        .currentStage(userstory.getCurrentStage())
                        .username(userstory.getAssignee().getAssignee().getUsername())
                        .tasks(userstory.getTasks())
                        .build();
                listedUserstories.add(userstoryListingDTO);
            }else{
                UserstoryListingDTO userstoryListingDTO= UserstoryListingDTO.builder()
                        .id(userstory.getId())
                        .name(userstory.getName())
                        .currentStage(userstory.getCurrentStage())
                        .username(null)
                        .tasks(userstory.getTasks())
                        .build();
                listedUserstories.add(userstoryListingDTO);
            }

        }

        return listedUserstories;





    }
    @Transactional
    public Userstory createAnUserstory(UserstoryCreationDTO request) {
        Userstory userstory= Userstory.builder()
                .name(request.getName())
                .currentStage(request.getCurrentStage())
                .description(request.getDescription())
                .complexity(0L)
                .build();

        List<Task> tasks = taskService.getTasks(request.getTasks());
        if (tasks != null && !tasks.isEmpty()) {
            userstory.setTasks(tasks);

        } else {
            userstory.setTasks(Collections.emptyList());
        }

        userStoryRepository.save(userstory);

        taskService.bindTaskToUserstory(userstory,request.getTasks());


        return userstory;

    }
    @Transactional
    public UserUserstory editUserstoryAssignee(UserstoryEditAssigneeDTO request) {


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUser_id()));

        Userstory userstory = userStoryRepository.findById(request.getUserstory_id())
                .orElseThrow(() -> new RuntimeException("Userstory not found with ID: " + request.getUserstory_id()));

        Optional<UserUserstory> userUserstoryOptional = userUserstoryRepository.findByUserstoryId(request.getUserstory_id());
        if (userUserstoryOptional.isPresent()) {
            UserUserstory userUserstory = userUserstoryOptional.get();
            userUserstory.setAssignee(user);
            userUserstory.setLast_edit(timestamp);
            userUserstoryRepository.save(userUserstory);
            user.getUserstories().add(userUserstory);
            userRepository.save(user);
            return  userUserstory;
        } else {
            UserUserstory userUserstory = UserUserstory
                    .builder()
                    .userstory(userstory)
                    .assignee(user)
                    .last_edit(timestamp)
                    .build();

            userUserstoryRepository.save(userUserstory);
            user.getUserstories().add(userUserstory);
            userRepository.save(user);
            return userUserstory;
        }
    }

    public Userstory editUserstory(UserstoryEditDTO request) {
        Userstory userstory = userStoryRepository.findById(request.getUserstoryEditAssigneeDTO().getUserstory_id())
                .orElseThrow(() -> new RuntimeException("Userstory not found with ID: " + request.getUserstoryEditAssigneeDTO().getUserstory_id()));

        userstory.setDescription(request.getDescription());
        userstory.setName(request.getName());
        userstory.setComplexity(request.getComplexity());
        userstory.setCurrentStage(request.getCurrentStage());

        List<Task> tasks = taskService.getTasks(request.getTasks());
        if (tasks != null && !tasks.isEmpty()) {
            userstory.setTasks(tasks);
            taskService.bindTaskToUserstory(userstory, request.getTasks());
        } else {
            userstory.setTasks(null);
        }

        editUserstoryAssignee(request.getUserstoryEditAssigneeDTO());

        return userstory;
    }


    public UserstoryGetDTO getAnUserstory(Long id) {
        Userstory userstory = userStoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Userstory not found with ID: " + id));


        UserstoryGetDTO userstoryGetDTO;
        if(userstory.getAssignee()!=null){
            User user = userRepository.findById(userstory.getAssignee().getAssignee().getId())
                    .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
            userstoryGetDTO = new UserstoryGetDTO();
            userstoryGetDTO.setUserstoryId(userstory.getId());
            userstoryGetDTO.setDescription(userstory.getDescription());
            userstoryGetDTO.setName(userstory.getName());
            userstoryGetDTO.setCurrentStage(userstory.getCurrentStage());
            userstoryGetDTO.setTasks(userstory.getTasks());
            userstoryGetDTO.setComplexity(userstory.getComplexity());
            userstoryGetDTO.setUserId(user.getId());
            userstoryGetDTO.setUsername(user.getUsername());
        }
        else{
            userstoryGetDTO = new UserstoryGetDTO();
            userstoryGetDTO.setUserstoryId(userstory.getId());
            userstoryGetDTO.setDescription(userstory.getDescription());
            userstoryGetDTO.setName(userstory.getName());
            userstoryGetDTO.setCurrentStage(userstory.getCurrentStage());
            userstoryGetDTO.setComplexity(userstory.getComplexity());
            userstoryGetDTO.setTasks(userstory.getTasks());
            userstoryGetDTO.setUserId(null);
            userstoryGetDTO.setUsername(null);

        }

        return userstoryGetDTO;
    }
}
