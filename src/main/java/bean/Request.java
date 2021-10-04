package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    private Integer id;
    private User user;
    private String dateCreate;
    private Route route;
    private String dateDeparture;
    private String statusRequest;
    private String typeTransport;
    private String detailsRequest;
}
