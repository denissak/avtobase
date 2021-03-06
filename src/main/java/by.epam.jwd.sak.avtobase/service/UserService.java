package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.ServiceException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto findByLogin(String login) throws ServiceException;

    boolean create(UserDto userDto) throws ServiceException;

    List<UserDto> findAllUser() throws ServiceException;

    List<UserDto> findAllDisabledUser() throws ServiceException;

    List<UserDto> findAllDrivers() throws ServiceException;

    boolean update(UserDto entity) throws ServiceException;

    Optional<UserDto> findById(Long id) throws ServiceException;

    boolean delete(Long id) throws ServiceException;

    boolean restore(Long id) throws ServiceException;


}
