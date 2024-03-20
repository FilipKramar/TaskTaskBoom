package com.atos.projektpraksa.task.dto;

import com.atos.projektpraksa.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskListingDTO {

    Long id;

    String description;

    String username;

    Status status;

}
