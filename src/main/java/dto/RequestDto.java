package dto;

import bean.StatusRequest;
import bean.TypeTransport;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class RequestDto {

    Integer id;
    LocalDateTime dateCreate;
    String startAddress;
    String endAddress;
    LocalDateTime dateDeparture;
    StatusRequest statusRequest;
    TypeTransport typeTransport;
    String detailsRequest;

}
