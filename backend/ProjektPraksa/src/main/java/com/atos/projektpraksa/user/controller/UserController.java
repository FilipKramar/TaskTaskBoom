package com.atos.projektpraksa.user.controller;

import com.atos.projektpraksa.user.dto.UserDTO;
import com.atos.projektpraksa.user.dto.UserListingDTO;
import com.atos.projektpraksa.user.dto.UserRegistrationDTO;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Long> authorizeAnUser(@RequestBody UserDTO userDTO){

        return ResponseEntity.ok(userService.authorizeAnUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserListingDTO>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());

}

        @PostMapping("/register")
    public ResponseEntity<List<User>> registerUsers(@RequestBody List<UserRegistrationDTO> request){
        return ResponseEntity.ok(userService.registerUsers(request));

    }
}
