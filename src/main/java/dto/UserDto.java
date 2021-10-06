package dto;

import lombok.Builder;
import lombok.Value;

import javax.management.relation.Role;

@Value
@Builder
public class UserDto {

    Integer id;
    String login;
    //String password;
    String role;
    String name;
    String surname;
    String phoneNumber;



}
