package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.bean.StatusRequest;
import by.epam.jwd.sak.avtobase.bean.TypeTransport;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    Integer id;
    //String user;
    UserDto userDto;
    LocalDateTime dateCreate;
    String startAddress;
    String endAddress;
    LocalDateTime dateDeparture;
    StatusRequest statusRequest;
    TypeTransport typeTransport;
    String detailsRequest;

}
