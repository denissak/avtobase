package dto;

import java.util.Objects;

public class RouteDto {

private final Integer id;
private final Integer startPoint;
private final Integer endPoint;
private final Integer kmSpent;
private final Integer hourSpent;

    public RouteDto(Integer id, Integer startPoint, Integer endPoint, Integer kmSpent, Integer hourSpent) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.kmSpent = kmSpent;
        this.hourSpent = hourSpent;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public Integer getEndPoint() {
        return endPoint;
    }

    public Integer getKmSpent() {
        return kmSpent;
    }

    public Integer getHourSpent() {
        return hourSpent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDto routeDto = (RouteDto) o;
        return Objects.equals(id, routeDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "id=" + id +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", kmSpent=" + kmSpent +
                ", hourSpent=" + hourSpent +
                '}';
    }
}
