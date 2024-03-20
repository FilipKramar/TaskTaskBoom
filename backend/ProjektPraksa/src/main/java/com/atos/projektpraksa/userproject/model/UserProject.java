package com.atos.projektpraksa.userproject.model;

import com.atos.projektpraksa.enums.Role;
import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.user.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User_Project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @Enumerated(EnumType.STRING)
    private Role role;


}
