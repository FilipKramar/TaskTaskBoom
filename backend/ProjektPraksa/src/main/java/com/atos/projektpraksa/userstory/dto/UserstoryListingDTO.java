package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.task.model.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserstoryListingDTO {

    Long id;

    String name;

    String username;

    CurrentStage currentStage;

    List<Task> tasks;
}
