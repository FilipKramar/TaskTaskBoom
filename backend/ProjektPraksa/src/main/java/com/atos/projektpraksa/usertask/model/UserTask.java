package com.atos.projektpraksa.usertask.model;

import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.user.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference

    private User assignee;

    @OneToOne
    @JoinColumn(name = "task_id")

    @JsonBackReference
    private Task task;

    private Timestamp last_edit;
}
