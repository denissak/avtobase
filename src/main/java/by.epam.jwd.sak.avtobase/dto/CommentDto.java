package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CommentDto {

    Long id;
    UserDto userDto;
    LocalDateTime commentDate;
    Integer mark;
    String message;
}
