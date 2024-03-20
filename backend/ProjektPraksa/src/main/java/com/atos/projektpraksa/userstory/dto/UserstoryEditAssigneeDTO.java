package com.atos.projektpraksa.userstory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserstoryEditAssigneeDTO {

    Long userstory_id;
    Long user_id;
}
