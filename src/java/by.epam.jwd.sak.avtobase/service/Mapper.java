package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.Driver;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dto.CarDto;
import by.epam.jwd.sak.avtobase.dto.DriverDto;
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
    public static Driver convertToDriver(DriverDto driverDto) {
        return Driver.builder()
                .user(Mapper.convertToUser(driverDto.getUserDto()))
                .doctorStamp(driverDto.getDoctorStamp())
                .build();
    }
}
