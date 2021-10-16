package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.bean.StatusCar;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CarDto {
    
    Integer id;
    DriverDto driverDto;
    String mark;
    String model;
    LocalDateTime releaseDate;
    TypeTransport typeTransport;
    Integer liftingCapacity;
    Integer cargoCapacity;
    Integer passengerCapacity;
    LocalDateTime inspectionPermission;
    StatusCar statusCar;
    String carDescription;

    
}
