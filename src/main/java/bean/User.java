package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone_number;
    private Integer roleId;


}
