package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDateTime doctorStamp;
    private Car car;
    private boolean isBusy; //TODO

    public Driver() {
    }

    public Driver(Integer id, LocalDateTime doctorStamp, Car car, boolean isBusy) {
        this.id = id;
        this.doctorStamp = doctorStamp;
        this.car = car;
        this.isBusy = isBusy;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDoctorStamp() {
        return doctorStamp;
    }

    public void setDoctorStamp(LocalDateTime doctorStamp) {
        this.doctorStamp = doctorStamp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id.equals(driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Driver ");
        sb.append("id = ");
        sb.append(id);
        sb.append(", doctorStamp = ");
        sb.append(doctorStamp);
        sb.append(", car = ");
        sb.append(car);
        sb.append(", isBusy = ");
        sb.append(isBusy);
        return sb.toString();
    }
}
