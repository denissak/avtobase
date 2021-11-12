package by.epam.jwd.sak.avtobase.entity;

import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder
public class DriverRequest implements Serializable {

    private User driver;
    private Request request;

    public DriverRequest() {
    }

    public DriverRequest(User driver, Request request) {
        this.driver = driver;
        this.request = request;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverRequest that = (DriverRequest) o;
        return Objects.equals(driver, that.driver) &&
                Objects.equals(request, that.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, request);
    }

    @Override
    public String toString() {
        return "DriverRequest{" +
                "driverId=" + driver +
                ", requestsId=" + request +
                '}';
    }
}
