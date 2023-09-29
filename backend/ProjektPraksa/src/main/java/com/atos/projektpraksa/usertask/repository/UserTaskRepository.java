package com.atos.projektpraksa.usertask.repository;

import com.atos.projektpraksa.task.model.Task;
import com.atos.projektpraksa.usertask.dto.UserTaskListingDTO;
import com.atos.projektpraksa.usertask.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

    @Query("SELECT NEW com.atos.projektpraksa.usertask.dto.UserTaskListingDTO(task.id,task.description,user.username,task.status,task.priority) " +
            "FROM UserTask ut " +
            "INNER JOIN ut.assignee user " +
            "INNER JOIN ut.task task " +
            "WHERE user.id = :id AND task.status != 'CLOSED'")
    List<UserTaskListingDTO> findUsersTasks(@Param("id") Long id);

    @Query("SELECT NEW com.atos.projektpraksa.usertask.dto.UserTaskListingDTO(task.id,task.description,user.username,task.status,task.priority) " +
            "FROM UserTask ut " +
            "INNER JOIN ut.assignee user " +
            "INNER JOIN ut.task task ")
    List<UserTaskListingDTO> findTasks();


    Optional<UserTask> findByTaskId(Long taskId);
}
