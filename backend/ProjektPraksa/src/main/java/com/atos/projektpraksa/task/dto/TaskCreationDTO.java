package com.atos.projektpraksa.task.dto;


import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.usertask.model.UserTask;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreationDTO {

    String description;

    Priority priority;

    Long user_id;


}
