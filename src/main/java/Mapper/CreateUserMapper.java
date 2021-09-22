package Mapper;


import bean.User;
import dto.UserCreateDto;


public class CreateUserMapper implements Mapper<UserCreateDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .login(object.getName())
                .password(object.getPassword())
               //.role(object.getRoleId())
                .name(object.getName())
                .surname(object.getSurname())
                .phone_number(object.getPhoneNumber())
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
