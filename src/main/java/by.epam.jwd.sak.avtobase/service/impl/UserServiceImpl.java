package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.entity.Role;
import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.PasswordEncoder;
import by.epam.jwd.sak.avtobase.service.UserService;
import by.epam.jwd.sak.avtobase.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public List<UserDto> findAllDrivers() throws ServiceException {
        try {
            return daoFactory.getUserDao().findAllDrivers().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error(e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<UserDto> findById(Long id) throws ServiceException {
        try {
            return daoFactory.getUserDao().findById(id).map(this::convertToUserDto);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return daoFactory.getUserDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean restore(Long id) throws ServiceException {
        try {
            return daoFactory.getUserDao().restore(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(UserDto entity) throws ServiceException {
        if (entity == null
                || !(UserValidator.isCorrectLogin(entity.getLogin())
                || UserValidator.isCorrectName(entity.getName())
                || UserValidator.isCorrectSurname(entity.getSurname())
                || UserValidator.isCorrectPhoneNumber(entity.getPhoneNumber()))) {
            return false;
        }
        User userBean = convertToUser(entity);
        try {
            daoFactory.getUserDao().update(userBean);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    @Override
    public List<UserDto> findAllUser() throws ServiceException {
        try {
            return daoFactory.getUserDao().findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserDto> findAllDisabledUser() throws ServiceException {
        try {
            return daoFactory.getUserDao().findAllDisabledUser().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserDto> findAllFreeDrivers(Date date) throws ServiceException {
        try {
            return daoFactory.getUserDao().findAllFreeDrivers(date).stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public UserDto findByLogin(String login) throws ServiceException {
        try {
            return convertToUserDto(daoFactory.getUserDao().findByLogin(login));

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public boolean create(UserDto userDto) throws ServiceException {
        if (userDto == null
                || !(UserValidator.isCorrectLogin(userDto.getLogin())
                || UserValidator.isCorrectName(userDto.getName())
                || UserValidator.isCorrectSurname(userDto.getSurname())
                || UserValidator.isCorrectPhoneNumber(userDto.getPhoneNumber()))) {
            return false;
        }
        User userBean = convertToUser(userDto);
        try {
            daoFactory.getUserDao().save(userBean);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return true;
    }

    private UserDto convertToUserDto(User object) {
        return UserDto.builder()
                .id(object.getId())
                .password(object.getPassword())
                .login(object.getLogin())
                .role(object.getRole().getName())
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .build();
    }

    private User convertToUser(UserDto object) {
        int role = 4;
        if (object.getRole() != null) {
            role = Integer.valueOf(object.getRole());
        }
        return User.builder()
                .id(object.getId())
                .login(object.getLogin())
                .password(PasswordEncoder.getInstance().encrypt(object.getPassword()))
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .role(new Role((long) role, null))
                .build();
    }
}
