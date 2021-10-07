package by.epam.jwd.sak.avtobase.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String phoneNumber;
    private Role role;


}
