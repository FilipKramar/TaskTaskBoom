package com.atos.projektpraksa.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEditAssigneeDTO {

    Long userid;
    Long taskid;
}
