package Mapper;

import bean.Request;
import dto.RequestDto;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RequestMapper implements Mapper<Request, RequestDto>{

    private static final RequestMapper INSTANCE = new RequestMapper();

    public static RequestMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public RequestDto mapFrom(Request object) {
        return RequestDto.builder()
                .id(object.getId())
                .dateCreate(object.getDateCreate())
                .startAddress(object.getStartAddress())
                .endAddress(object.getEndAddress())
                .dateDeparture(object.getDateDeparture())
                .statusRequest(object.getStatusRequest())
                .typeTransport(object.getTypeTransport())
                .detailsRequest(object.getDetailsRequest())
                .build();
    }
}
