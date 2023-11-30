package com.atos.projektpraksa.userstory.model;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Userstories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Userstory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    String name;

    Long complexity;

    @Enumerated(EnumType.STRING)
    CurrentStage currentStage;


    @OneToMany(mappedBy = "userstory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Task> tasks;


    @OneToOne(mappedBy = "userstory",fetch = FetchType.LAZY)
    @JsonManagedReference
    UserUserstory assignee;

    @ManyToOne
    @JoinColumn(name = "project")
    @JsonManagedReference
    Project project;
}
