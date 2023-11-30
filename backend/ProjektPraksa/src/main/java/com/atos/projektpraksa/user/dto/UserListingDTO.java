package com.atos.projektpraksa.user.dto;

import lombok.*;

@Data@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListingDTO {

    Long id;

    String username;

    String firstName;

    String lastName;

}
