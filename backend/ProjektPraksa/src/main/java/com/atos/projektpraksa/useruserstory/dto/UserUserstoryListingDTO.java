package com.atos.projektpraksa.useruserstory.dto;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUserstoryListingDTO {

    private Long id;
    private String name;
    private String username;
    CurrentStage currentStage;
}
