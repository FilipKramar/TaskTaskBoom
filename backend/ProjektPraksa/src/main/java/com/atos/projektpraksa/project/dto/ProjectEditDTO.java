package com.atos.projektpraksa.project.dto;

import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.userproject.model.UserProject;
import com.atos.projektpraksa.userstory.model.Userstory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEditDTO {
    Long id;

    String name;

    String description;

    Timestamp startDate;

    Timestamp endDate;

    List<Long> usersId;

}
