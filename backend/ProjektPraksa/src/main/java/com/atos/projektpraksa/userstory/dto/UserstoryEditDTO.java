package com.atos.projektpraksa.userstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserstoryEditDTO {
    String description;

    String name;

    Long complexity;

    CurrentStage currentStage;

    UserstoryEditAssigneeDTO userstoryEditAssigneeDTO;

    List<Long> tasks;

}
