package com.atos.projektpraksa.task.dto;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEditDTO {
    String description;

    Priority priority;

    Status status;

    Long complexity;

   TaskEditAssigneeDTO taskEditAssigneeDTO;
}
