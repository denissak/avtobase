package by.epam.jwd.sak.avtobase.dto;

import by.epam.jwd.sak.avtobase.entity.StatusRequest;
import by.epam.jwd.sak.avtobase.entity.TypeTransport;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    Long id;
    UserDto userDto;
    LocalDateTime dateCreate;
    String startAddress;
    String endAddress;
    LocalDate dateDeparture;
    StatusRequest statusRequest;
    TypeTransport typeTransport;
    String detailsRequest;

}
