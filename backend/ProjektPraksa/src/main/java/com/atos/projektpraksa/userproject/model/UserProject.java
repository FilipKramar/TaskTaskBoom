package com.atos.projektpraksa.userproject.model;

import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_Project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String role;


}
