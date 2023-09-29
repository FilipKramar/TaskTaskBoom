package com.atos.projektpraksa.task.dto;

import com.atos.projektpraksa.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskListingDTO {

    Long id;

    String description;

    String username;

    Status status;

}
