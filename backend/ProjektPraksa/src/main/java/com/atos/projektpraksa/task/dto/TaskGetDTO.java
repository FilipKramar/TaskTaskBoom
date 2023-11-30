package com.atos.projektpraksa.task.dto;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskGetDTO {

    Long user_id;
    String username;
    Long task_id;
    String description;
    Status status;
    Priority priority;
    Long complexity;
}
