package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import by.epam.jwd.sak.avtobase.bean.User;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class RequestCreateDto {

    String id;
    String user;
    String dateCreate;
    String startAddress;
    String endAddress;
    String dateDeparture;
    String statusRequest;
    String typeTransport;
    String detailsRequest;

}
