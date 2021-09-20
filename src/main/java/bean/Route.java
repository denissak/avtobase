package bean;

import java.io.Serializable;
import java.util.Objects;

public class Route implements Serializable {

    private Integer id;
    private Integer startPoint;
    private Integer endPoint;
    private Integer kmSpent;
    private Integer hourSpent;

    public Route() {
    }

    public Route(Integer id, Integer startPoint, Integer endPoint, Integer kmSpent, Integer hourSpent) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.kmSpent = kmSpent;
        this.hourSpent = hourSpent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    public Integer getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Integer endPoint) {
        this.endPoint = endPoint;
    }

    public Integer getKmSpent() {
        return kmSpent;
    }

    public void setKmSpent(Integer kmSpent) {
        this.kmSpent = kmSpent;
    }

    public Integer getHourSpent() {
        return hourSpent;
    }

    public void setHourSpent(Integer hourSpent) {
        this.hourSpent = hourSpent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", kmSpent=" + kmSpent +
                ", hourSpent=" + hourSpent +
                '}';
    }
}
