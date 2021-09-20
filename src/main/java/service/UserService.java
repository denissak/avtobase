package service;

import Mapper.CreateUserMapper;
import bean.User;
import dao.UserDao;
import dto.UserCreateDto;
import exception.ValidationException;
import validator.CreateUserValidator;
import validator.ValidationResult;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create (UserCreateDto userCreateDto){
        ValidationResult validationResult = createUserValidator.isValid(userCreateDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        User userBean = createUserMapper.mapFrom(userCreateDto);
        userDao.save(userBean);
        return userBean.getId();


    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
