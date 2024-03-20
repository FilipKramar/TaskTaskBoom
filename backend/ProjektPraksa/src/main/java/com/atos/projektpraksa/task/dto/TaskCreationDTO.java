package com.atos.projektpraksa.task.dto;


import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.usertask.model.UserTask;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreationDTO {

    String description;

    Priority priority;

    Long user_id;


}
