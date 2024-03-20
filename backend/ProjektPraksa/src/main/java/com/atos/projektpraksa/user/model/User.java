package com.atos.projektpraksa.user.model;


import com.atos.projektpraksa.userproject.model.UserProject;
import com.atos.projektpraksa.usertask.model.UserTask;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
>>>>>>> parent of b8019f4 (Revert "Merge branch 'backend'")

import java.util.List;

@Entity
@Table(name = "users")
<<<<<<< HEAD
@Data
=======
@Getter
@Setter
>>>>>>> parent of b8019f4 (Revert "Merge branch 'backend'")
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


    @OneToMany(mappedBy = "user")
    private List<UserProject> userProjects;


<<<<<<< HEAD
    @OneToMany(mappedBy = "assignee")
=======
    @OneToMany(mappedBy = "assignee",fetch = FetchType.LAZY)
>>>>>>> parent of b8019f4 (Revert "Merge branch 'backend'")
    @JsonManagedReference
    List<UserTask> tasks;

    @OneToMany(mappedBy = "assignee")
    @JsonManagedReference
    List<UserUserstory> userstories;

}
