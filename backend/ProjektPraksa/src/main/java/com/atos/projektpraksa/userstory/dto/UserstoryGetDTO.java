package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
