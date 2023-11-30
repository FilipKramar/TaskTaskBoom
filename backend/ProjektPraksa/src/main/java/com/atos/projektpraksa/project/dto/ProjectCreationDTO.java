package com.atos.projektpraksa.project.dto;

import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.userproject.model.UserProject;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreationDTO {

    String name;
    String description;
    Timestamp startDate;
    Timestamp endDate;

}
