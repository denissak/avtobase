package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class CarDto {
    
    Integer id;
    UserDto userDto;
    String mark;
    String model;
    LocalDate releaseDate;
    TypeTransport typeTransport;
    Integer liftingCapacity;
    Integer cargoCapacity;
    Integer passengerCapacity;
    LocalDate inspectionPermission;
    StatusCar statusCar;
    String carDescription;

    
}
