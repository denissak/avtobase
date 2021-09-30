package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateDto {

    String login;
    String password;
    String name;
    String surname;
    String phoneNumber;


}
