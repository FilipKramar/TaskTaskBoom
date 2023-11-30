package com.atos.projektpraksa.useruserstory.model;

import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_userstory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUserstory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User assignee;

    @OneToOne
    @JoinColumn(name = "userstory_id")
    @JsonBackReference
    private Userstory userstory;

    private Timestamp last_edit;
}
