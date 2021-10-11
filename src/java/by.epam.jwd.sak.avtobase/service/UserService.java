package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDto> findByLoginAndPassword (String login, String password);

    Integer create (UserDto userDto);

    List<UserDto> findAllUser ();

}
