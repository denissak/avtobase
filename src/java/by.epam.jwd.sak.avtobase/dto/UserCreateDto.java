package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateDto {

    Integer id;
    String login;
    String password;
    String name;
    String surname;
    String phoneNumber;


}
