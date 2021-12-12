package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.dao.UserDao;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger();
    private final UserDao userDao = DaoFactory.getInstance().getUserDao();


    @Override
    public List<UserDto> findAllDrivers() throws ServiceException {
        try {
            return userDao.findAllDrivers().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all drivers error service", e);
            throw new ServiceException("Find all drivers error service", e);
        }
    }

    @Override
    public Optional<UserDto> findById(Long id) throws ServiceException {
        try {
            return userDao.findById(id).map(this::convertToUserDto);
        } catch (DAOException e) {
            LOGGER.error("Find user by id error service", e);
            throw new ServiceException("Find user by id error service", e);
        }
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        try {
            return userDao.delete(id);
        } catch (DAOException e) {
            LOGGER.error("Delete user error service", e);
            throw new ServiceException("Delete user error service", e);
        }
    }

    @Override
    public boolean restore(Long id) throws ServiceException {
        try {
            return userDao.restore(id);
        } catch (DAOException e) {
            LOGGER.error("Restore user error service", e);
            throw new ServiceException("Restore user error service", e);
        }
    }

    @Override
    public boolean update(UserDto userDto) throws ServiceException {
        if (userDto == null || !(UserValidator.isUserValid(userDto))) {
            return false;
        }
        User userBean = convertToUser(userDto);
        try {
            userDao.update(userBean);
        } catch (DAOException e) {
            LOGGER.error("Update user error service", e);
            throw new ServiceException("Update user error service", e);
        }
        return true;
    }

    @Override
    public List<UserDto> findAllUser() throws ServiceException {
        try {
            return userDao.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all users error service", e);
            throw new ServiceException("Find all users error service", e);
        }
    }

    @Override
    public List<UserDto> findAllDisabledUser() throws ServiceException {
        try {
            return userDao.findAllDisabledUser().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            LOGGER.error("Find all disabled users error service", e);
            throw new ServiceException("Find all disabled users error service", e);
        }
    }

    @Override
    public UserDto findByLogin(String login) throws ServiceException {
        try {
            return convertToUserDto(userDao.findByLogin(login));

        } catch (DAOException e) {
            LOGGER.error("Find user by login error service", e);
            throw new ServiceException("Find user by login error service", e);
        }
    }

    @Override
    public boolean create(UserDto userDto) throws ServiceException {
        if (userDto == null || !(UserValidator.isUserValid(userDto))) {
            return false;
        }
        User userBean = convertToUser(userDto);
        try {
            userDao.save(userBean);
        } catch (DAOException e) {
            LOGGER.error("Create user error service", e);
            throw new ServiceException("Create user error service", e);
        }
        return true;
    }

    private UserDto convertToUserDto(User object) {
        if (object == null){
            return null;
        }else {
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
