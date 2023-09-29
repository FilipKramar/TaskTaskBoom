package com.atos.projektpraksa.useruserstory.Controller;

import com.atos.projektpraksa.usertask.dto.UserTaskListingDTO;
import com.atos.projektpraksa.useruserstory.dto.UserUserstoryListingDTO;
import com.atos.projektpraksa.useruserstory.repository.UserUserstoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/useruserstories")
@AllArgsConstructor
public class UserUserstoryController {

    private final UserUserstoryRepository userUserstoryRepository;

    @GetMapping
    public ResponseEntity<List<UserUserstoryListingDTO>> getAllAssigneedUserstories (){

        return ResponseEntity.ok(userUserstoryRepository.findUserstories());
    }
}
