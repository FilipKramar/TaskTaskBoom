package com.atos.projektpraksa.userstory.controller;

import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import com.atos.projektpraksa.userstory.dto.*;
import com.atos.projektpraksa.userstory.model.Userstory;
import com.atos.projektpraksa.userstory.service.UserstoryService;
import com.atos.projektpraksa.useruserstory.model.UserUserstory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/userstories")
public class UserstoryController {

    private final UserstoryService userstoryService;

    @GetMapping
    public ResponseEntity<List<UserstoryListingDTO>> getAllUserstories()
    {

        return ResponseEntity.ok(userstoryService.getAllUserstories());

    }
    @PostMapping
    public ResponseEntity<Userstory> createAnUserstory(@RequestBody UserstoryCreationDTO request)
    {

        return ResponseEntity.ok(userstoryService.createAnUserstory(request));
    }

    @PatchMapping
    public ResponseEntity<UserUserstory> editUserstoryAssignee (@RequestBody UserstoryEditAssigneeDTO request)
    {
        return ResponseEntity.ok(userstoryService.editUserstoryAssignee(request));
    }
    @PutMapping
    public ResponseEntity<Userstory> editUserstory(@RequestBody UserstoryEditDTO request){
        return ResponseEntity.ok(userstoryService.editUserstory(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserstoryGetDTO> getAnUserstory(@PathVariable Long id){
        return ResponseEntity.ok(userstoryService.getAnUserstory(id));
    }

}
