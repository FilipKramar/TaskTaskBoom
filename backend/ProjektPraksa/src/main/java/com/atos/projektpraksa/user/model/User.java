package com.atos.projektpraksa.user.model;


import com.atos.projektpraksa.usertask.model.UserTask;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String username;

    String password;

    String firstName;

    String lastName;


//    @OneToMany(mappedBy = "user")
//    private List<UserProject> userProjects;


    @OneToMany(mappedBy = "assignee",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<UserTask> tasks;

    @OneToMany(mappedBy = "assignee")
    @JsonManagedReference
    List<UserUserstory> userstories;

}
