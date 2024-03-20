package com.atos.projektpraksa.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    Date start_date;

    Date end_date;

//    @OneToMany(mappedBy = "project")
//    private List<UserProject> userProjects;

//    @OneToMany(mappedBy = "project")
//    List<Task> tasks;

//    @OneToMany(mappedBy = "project")
//    List<Userstory> userstories;

}
