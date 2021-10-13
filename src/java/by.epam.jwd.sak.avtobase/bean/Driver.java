package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private User user;
    private LocalDateTime doctorStamp;
    private Car car;
    //private boolean isBusy; //TODO

    public Driver() {
    }

    public Driver(Integer id, User user, LocalDateTime doctorStamp, Car car) {
        this.id = id;
        this.user = user;
        this.doctorStamp = doctorStamp;
        this.car = car;

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

    public Car getCarId() {
        return car;
    }

    public void setCarId(Car car) {
        this.car = car;
    }

/*    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }*/

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = user;
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
/*        sb.append(", isBusy = ");
        sb.append(isBusy);*/
        sb.append(", user = ");
        sb.append(user);
        return sb.toString();
    }
}
