package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DriverRequestDto {

    UserDto userDto;
    RequestDto requestDto;
}
