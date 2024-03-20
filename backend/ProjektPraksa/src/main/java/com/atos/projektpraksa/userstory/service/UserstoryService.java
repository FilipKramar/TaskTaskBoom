package com.atos.projektpraksa.userstory.service;

import com.atos.projektpraksa.task.dto.TaskEditAssigneeDTO;
import com.atos.projektpraksa.task.dto.TaskListingDTO;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.user.dto.UserListingDTO;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import com.atos.projektpraksa.userstory.dto.UserstoryCreationDTO;
import com.atos.projektpraksa.userstory.dto.UserstoryEditAssigneeDTO;
import com.atos.projektpraksa.userstory.dto.UserstoryEditDTO;
import com.atos.projektpraksa.userstory.dto.UserstoryListingDTO;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.atos.projektpraksa.userstory.repository.UserStoryRepository;
import com.atos.projektpraksa.usertask.model.UserTask;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import com.atos.projektpraksa.useruserstory.repository.UserUserstoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserstoryService {

    private final UserStoryRepository userStoryRepository;
    private final UserUserstoryRepository userUserstoryRepository;
    private final UserRepository userRepository;
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
                        .build();
                listedUserstories.add(userstoryListingDTO);
            }else{
                UserstoryListingDTO userstoryListingDTO= UserstoryListingDTO.builder()
                        .id(userstory.getId())
                        .name(userstory.getName())
                        .currentStage(userstory.getCurrentStage())
                        .username(null)
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

        userStoryRepository.save(userstory);


        return userstory;

    }
    @Transactional
    public Userstory editUserstoryAssignee(UserstoryEditAssigneeDTO request) {


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUser_id()));

        Userstory userstory = userStoryRepository.findById(request.getUserstory_id())
                .orElseThrow(() -> new RuntimeException("Userstory not found with ID: " + request.getUserstory_id()));

        Optional<UserUserstory> userUserstoryOptional = userUserstoryRepository.findByUserstoryId(request.getUserstory_id());
        if (userUserstoryOptional.isPresent()) {
            user.getUserstories().add(userUserstoryOptional.get());
            userRepository.save(user);
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
        }

        return userstory;
    }

        public Userstory editUserstory(UserstoryEditDTO request) {
        Userstory userstory = userStoryRepository.findById(request.getUserstoryEditAssigneeDTO().getUserstory_id())
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + request.getUserstoryEditAssigneeDTO().getUserstory_id()));


        userstory.setDescription(request.getDescription());
        userstory.setName(request.getName());
        userstory.setComplexity(request.getComplexity());
        userstory.setCurrentStage(request.getCurrentStage());

        editUserstoryAssignee(request.getUserstoryEditAssigneeDTO());
        return userstory;
    }
}

