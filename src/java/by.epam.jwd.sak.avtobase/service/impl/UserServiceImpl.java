package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.exception.DAOException;
import by.epam.jwd.sak.avtobase.exception.ServiceException;
import by.epam.jwd.sak.avtobase.service.UserService;
import by.epam.jwd.sak.avtobase.validator.CreateUserValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final DaoFactory daoFactory = DaoFactory.getInstance();


    @Override
    public Optional<UserDto> findById(Integer id) throws ServiceException {
        try {
            return daoFactory.getUserDao().findById(id).map(this::convertToUserDto);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public boolean delete (Integer id) throws ServiceException {
        try {
            return daoFactory.getUserDao().delete(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer update(UserDto entity) throws ServiceException {
        User userBean = convertToUser(entity);
        try {
            daoFactory.getUserDao().update(userBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return userBean.getId();
    }

    @Override
    public List<UserDto> findAllUser() throws ServiceException {
        try {
            return daoFactory.getUserDao().findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<UserDto> findByLoginAndPassword (String login, String password) throws ServiceException {
        try {
            return daoFactory.getUserDao().findByLoginAndPassword(login,password)
                    .map(this::convertToUserDto);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Integer create (UserDto userDto) throws ServiceException {
/*        ValidationResult validationResult = createUserValidator.isValid(userCreateDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }*/
        User userBean = convertToUser(userDto);
        try {
            daoFactory.getUserDao().save(userBean);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return userBean.getId();
    }

    private UserDto convertToUserDto(User object) {
        return UserDto.builder()
                .id(object.getId())
                .login(object.getLogin())
                .role(object.getRole().getName())
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .build();
    }

    private User convertToUser(UserDto object) {
        return User.builder()
                .id(object.getId())
                .login(object.getLogin())
                .password(object.getPassword())
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .build();
    }

}
