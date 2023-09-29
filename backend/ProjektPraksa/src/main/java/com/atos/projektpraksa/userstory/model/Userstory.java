package com.atos.projektpraksa.userstory.model;

import com.atos.projektpraksa.enums.CurrentStage;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Userstories")
@Data
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


//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    Project project;


    @OneToOne(mappedBy = "userstory")
    @JsonManagedReference
    UserUserstory assignee;
}
