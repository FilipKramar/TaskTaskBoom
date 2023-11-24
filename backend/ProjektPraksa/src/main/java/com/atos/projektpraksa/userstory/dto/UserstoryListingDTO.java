package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
