package com.atos.projektpraksa.userstory.repository;

import com.atos.projektpraksa.userstory.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<Userstory,Long> {
}
