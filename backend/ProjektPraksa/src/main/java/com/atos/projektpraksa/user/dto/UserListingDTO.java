package com.atos.projektpraksa.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListingDTO {

    Long id;

    String username;

    String firstName;

    String lastName;

}
