package com.atos.projektpraksa.useruserstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUserstoryListingDTO {

    private Long id;
    private String name;
    private String username;
    CurrentStage currentStage;
}
