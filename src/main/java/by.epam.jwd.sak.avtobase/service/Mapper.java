package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.entity.User;
import by.epam.jwd.sak.avtobase.dto.UserDto;

public final class Mapper {

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User convertToUser(UserDto object) {
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
