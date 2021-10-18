package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.bean.Role;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    Integer id;
    String login;
    String password;
    String role;
    String name;
    String surname;
    String phoneNumber;
}
