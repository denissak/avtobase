package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dto.UserDto;

public final class Mapper {

    public static User convertToUser (UserDto object) {
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
