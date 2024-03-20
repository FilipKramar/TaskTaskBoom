package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.task.model.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserstoryGetDTO {

    String description;

    String name;

    Long complexity;

    CurrentStage currentStage;

    Long userstoryId;

    Long userId;
    String username;

    List<Task> tasks;

}
