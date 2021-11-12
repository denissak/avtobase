package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.entity.StatusCar;
import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class CarDto {
    
    Long id;
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
