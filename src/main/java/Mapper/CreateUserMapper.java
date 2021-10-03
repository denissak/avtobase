package Mapper;


import bean.User;
import dto.UserCreateDto;


public class CreateUserMapper implements Mapper<UserCreateDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .login(object.getLogin())
                .password(object.getPassword())
                .name(object.getName())
                .surname(object.getSurname())
                .phoneNumber(object.getPhoneNumber())
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
