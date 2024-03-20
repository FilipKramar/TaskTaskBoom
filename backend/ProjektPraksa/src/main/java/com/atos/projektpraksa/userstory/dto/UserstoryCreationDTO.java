package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.task.model.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserstoryCreationDTO {

    String description;

    String name;

    CurrentStage currentStage;

    List<Long> tasks;

    }