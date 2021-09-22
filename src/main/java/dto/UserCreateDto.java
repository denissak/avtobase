package dto;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class UserCreateDto {

    String login;
    String password;
    //String roleId;
    String name;
    String surname;
    String phoneNumber;


}
