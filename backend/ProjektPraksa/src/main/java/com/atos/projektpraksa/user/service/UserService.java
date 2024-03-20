package com.atos.projektpraksa.user.service;

import com.atos.projektpraksa.user.dto.UserDTO;
import com.atos.projektpraksa.user.dto.UserListingDTO;
import com.atos.projektpraksa.user.dto.UserRegistrationDTO;
import com.atos.projektpraksa.user.model.User;
import com.atos.projektpraksa.user.repository.UserRepository;
import   lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long authorizeAnUser(UserDTO userDTO) {

        Optional<User> fetchedUser = userRepository.findByUsername(userDTO.getUsername());

        if (fetchedUser.isEmpty()) {
            throw new RuntimeException("User with the username: " + userDTO.getUsername() + "does not exist");
        }
        return fetchedUser.get().getId();
    }

    public List<UserListingDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserListingDTO> listedUsers = new ArrayList<>();

        for (User user : users) {
            UserListingDTO listedUser = UserListingDTO.builder()
                    .username(user.getUsername())
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .build();

            listedUsers.add(listedUser);
        }

        return listedUsers;
    }


    public List<User> registerUsers(List<UserRegistrationDTO> request) {
        List<User> registerUsers = new ArrayList<>();

        for (UserRegistrationDTO registrationDTO : request) {
            User user = User.builder()
                    .username(registrationDTO.getUsername())
                    .password(registrationDTO.getPassword())
                    .firstName(registrationDTO.getFirstName())
                    .lastName(registrationDTO.getLastName())
                    .build();

            userRepository.save(user);
            registerUsers.add(user);
        }
        return registerUsers;

    }

}
