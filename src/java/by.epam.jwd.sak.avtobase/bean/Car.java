package by.epam.jwd.sak.avtobase.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Car {
    private Integer id;
    private String mark;
    private String model;
    private LocalDate releaseDate;
    private String type;
    private Integer liftingCapacity;
    private Integer cargoCapacity;
    private Integer passengerCapacity;
    private LocalDate inspectionPermission;
    private String statusCar; //TODO
    private String carDescription;
    private String imagePath;
}
