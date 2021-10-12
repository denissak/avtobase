package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String mark;
    private String model;
    private LocalDateTime releaseDate;
    private TypeTransport typeTransport;
    private Integer liftingCapacity;
    private Integer cargoCapacity;
    private Integer passengerCapacity;
    private LocalDateTime inspectionPermission;
    private StatusCar statusCar; //TODO
    private String carDescription;
    private String imagePath;


    public Car() {
    }

    public Car(Integer id, String mark, String model, LocalDateTime releaseDate, TypeTransport typeTransport, Integer liftingCapacity,
               Integer cargoCapacity, Integer passengerCapacity, LocalDateTime inspectionPermission, StatusCar statusCar,
               String carDescription, String imagePath) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.releaseDate = releaseDate;
        this.typeTransport = typeTransport;
        this.liftingCapacity = liftingCapacity;
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
        this.inspectionPermission = inspectionPermission;
        this.statusCar = statusCar;
        this.carDescription = carDescription;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setType(TypeTransport type) {
        this.typeTransport = typeTransport;
    }

    public Integer getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(Integer liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public Integer getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Integer cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public LocalDateTime getInspectionPermission() {
        return inspectionPermission;
    }

    public void setInspectionPermission(LocalDateTime inspectionPermission) {
        this.inspectionPermission = inspectionPermission;
    }

    public StatusCar getStatusCar() {
        return statusCar;
    }

    public void setStatusCar(StatusCar statusCar) {
        this.statusCar = statusCar;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car ");
        sb.append("id = ");
        sb.append(id);
        sb.append(", mark = ");
        sb.append(mark);
        sb.append(", model = ");
        sb.append(model);
        sb.append(", releaseDate = ");
        sb.append(releaseDate);
        sb.append(", type = ");
        sb.append(typeTransport);
        sb.append(", liftingCapacity = ");
        sb.append(liftingCapacity);
        sb.append(", cargoCapacity = ");
        sb.append(cargoCapacity);
        sb.append(", passengerCapacity = ");
        sb.append(passengerCapacity);
        sb.append(", inspectionPermission = ");
        sb.append(inspectionPermission);
        sb.append(", statusCar = ");
        sb.append(statusCar);
        sb.append(", carDescription = ");
        sb.append(carDescription);
        sb.append(", imagePath = ");
        sb.append(imagePath);
        return sb.toString();
    }
}
