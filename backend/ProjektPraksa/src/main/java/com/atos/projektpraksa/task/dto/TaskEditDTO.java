package com.atos.projektpraksa.task.dto;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEditDTO {
    String description;

    Priority priority;

    Status status;

    Long complexity;

   TaskEditAssigneeDTO taskEditAssigneeDTO;
}
