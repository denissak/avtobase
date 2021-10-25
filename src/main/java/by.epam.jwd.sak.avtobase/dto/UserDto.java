package by.epam.jwd.sak.avtobase.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    Long id;
    String login;
    String password;
    String role;
    String name;
    String surname;
    String phoneNumber;
}
