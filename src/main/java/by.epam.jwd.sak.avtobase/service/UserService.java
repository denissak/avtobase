package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto findByLogin(String login) throws ServiceException;

    Integer create(UserDto userDto) throws ServiceException;

    List<UserDto> findAllUser(Integer limit) throws ServiceException;

    List<UserDto> findAllDrivers() throws ServiceException;

    Integer update(UserDto entity) throws ServiceException;

    Optional<UserDto> findById(Integer id) throws ServiceException;

    boolean delete(Integer id) throws ServiceException;

}
