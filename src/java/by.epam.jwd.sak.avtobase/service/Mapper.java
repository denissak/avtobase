package by.epam.jwd.sak.avtobase.service;

import by.epam.jwd.sak.avtobase.bean.Car;
import by.epam.jwd.sak.avtobase.bean.User;
import by.epam.jwd.sak.avtobase.dto.CarDto;
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
    public static Car convertToCar(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .mark(carDto.getMark())
                .model(carDto.getModel())
                .releaseDate(carDto.getReleaseDate())
                .typeTransport(carDto.getTypeTransport())
                .liftingCapacity(carDto.getLiftingCapacity())
                .cargoCapacity(carDto.getCargoCapacity())
                .passengerCapacity(carDto.getPassengerCapacity())
                .inspectionPermission(carDto.getInspectionPermission())
                .statusCar(carDto.getStatusCar())
                .carDescription(carDto.getCarDescription())
                .build();
    }
}
