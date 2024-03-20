package com.atos.projektpraksa.task.model;

import com.atos.projektpraksa.enums.Priority;
import com.atos.projektpraksa.enums.Status;
import com.atos.projektpraksa.usertask.model.UserTask;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "tasks")
@Data
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

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    Project project;


    @OneToOne(mappedBy = "task",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    UserTask assignee;

}
