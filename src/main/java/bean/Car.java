package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Car {
    private Integer id;
    private String mark;
    private String model;
    private String releaseDate;
    private String type;
    private Integer liftingCapacity;
    private Integer cargoCapacity;
    private Integer passengerCapacity;
    private String inspectionPermission;
    private String statusCar;
    private String carDescription;
    private String imagePath;
}
