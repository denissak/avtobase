package by.epam.jwd.sak.avtobase.service.impl;

import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dao.DaoFactory;
import by.epam.jwd.sak.avtobase.dto.UserDto;
import by.epam.jwd.sak.avtobase.service.UserService;
import by.epam.jwd.sak.avtobase.validator.CreateUserValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final DaoFactory daoFactory = DaoFactory.getInstance();



    @Override
    public Optional<UserDto> findByLoginAndPassword (String login, String password){
        return daoFactory.getUserDao().findByLoginAndPassword(login,password)
                .map(this::convertToUserDto);
    }

    @Override
    public Integer create (UserDto userDto){
/*        ValidationResult validationResult = createUserValidator.isValid(userCreateDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }*/
        User userBean = convertToUser(userDto);
        daoFactory.getUserDao().save(userBean);
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
