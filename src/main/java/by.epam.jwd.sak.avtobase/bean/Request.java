package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
public class Request  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private User user;
    private LocalDateTime dateCreate;
    private String startAddress;
    private String endAddress;
    private LocalDate dateDeparture;
    private StatusRequest statusRequest;
    private TypeTransport typeTransport;
    private String detailsRequest;

    public Request() {
    }

    public Request(Long id, User user, LocalDateTime dateCreate, String startAddress, String endAddress,
                   LocalDate dateDeparture, StatusRequest statusRequest, TypeTransport typeTransport, String detailsRequest) {
        this.id = id;
        this.user = user;
        this.dateCreate = dateCreate;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.dateDeparture = dateDeparture;
        this.statusRequest = statusRequest;
        this.typeTransport = typeTransport;
        this.detailsRequest = detailsRequest;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public LocalDate getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(LocalDate dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public StatusRequest getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(StatusRequest statusRequest) {
        this.statusRequest = statusRequest;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public String getDetailsRequest() {
        return detailsRequest;
    }

    public void setDetailsRequest(String detailsRequest) {
        this.detailsRequest = detailsRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id.equals(request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Request ");
        sb.append(" id = ");
        sb.append(id);
        sb.append(", user = ");
        sb.append(user);
        sb.append(", dateCreate = ");
        sb.append(dateCreate);
        sb.append(", statusRequest = ");
        sb.append(statusRequest);
        sb.append(", typeTransport = ");
        sb.append(typeTransport);
        sb.append(", detailsRequest = ");
        sb.append(detailsRequest);
        return sb.toString();
    }
}
