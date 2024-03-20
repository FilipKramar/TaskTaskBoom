package com.atos.projektpraksa.userproject.repository;

import com.atos.projektpraksa.project.model.Project;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.userproject.model.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long> {
    List<UserProject> findUserProjectsByProject(Project project);
}
