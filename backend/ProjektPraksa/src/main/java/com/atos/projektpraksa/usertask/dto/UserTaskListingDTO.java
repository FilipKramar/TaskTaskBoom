package com.atos.projektpraksa.usertask.dto;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskListingDTO {

    private Long id;
    private String description;
    private String username;
    Status status;
    Priority priority;

}
