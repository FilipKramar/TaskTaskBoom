package com.atos.projektpraksa.task.model;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.atos.projektpraksa.usertask.model.UserTask;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    @Enumerated(EnumType.STRING)
    Status status;

    @Enumerated(EnumType.STRING)
    Priority priority;

    Long complexity;

    @ManyToOne
    @JoinColumn(name = "userstory")
    @JsonBackReference
    Userstory userstory;


    @OneToOne(mappedBy = "task",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    UserTask assignee;

}
