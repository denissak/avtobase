package service;

import Mapper.CreateUserMapper;
import Mapper.UserMapper;
import bean.User;
import dao.UserDao;
import dto.UserCreateDto;
import dto.UserDto;
import exception.ValidationException;
import validator.CreateUserValidator;
import validator.ValidationResult;

import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    public Optional<UserDto> login (String login, String password){
        return userDao.findByLoginAndPassword(login,password)
                .map(userMapper::mapFrom);
    }

    public Integer create (UserCreateDto userCreateDto){
/*        ValidationResult validationResult = createUserValidator.isValid(userCreateDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }*/
        User userBean = createUserMapper.mapFrom(userCreateDto);
        userDao.save(userBean);
        return userBean.getId();


    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
