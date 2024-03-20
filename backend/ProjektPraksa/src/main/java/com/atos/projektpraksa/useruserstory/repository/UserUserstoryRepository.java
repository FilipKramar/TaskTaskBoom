package com.atos.projektpraksa.useruserstory.repository;

import com.atos.projektpraksa.usertask.dto.UserTaskListingDTO;
import com.atos.projektpraksa.useruserstory.dto.UserUserstoryListingDTO;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserUserstoryRepository extends JpaRepository<UserUserstory,Long> {
    Optional<UserUserstory> findByUserstoryId(Long userstoryId);

    @Query("SELECT NEW com.atos.projektpraksa.useruserstory.dto.UserUserstoryListingDTO(userstory.id,userstory.name,user.username,userstory.currentStage) " +
            "FROM UserUserstory ut " +
            "INNER JOIN ut.assignee user " +
            "INNER JOIN ut.userstory userstory ")
    List<UserUserstoryListingDTO> findUserstories();
}
