package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    Integer id;
    String login;
    String password;
    String role;
    String name;
    String surname;
    String phoneNumber;



}
