package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    private Integer id;
    private User user;
    private LocalDateTime dateCreate;
    private String startAddress;
    private String endAddress;
    private LocalDateTime dateDeparture;
    private StatusRequest statusRequest;
    private TypeTransport typeTransport;
    private String detailsRequest;
}
