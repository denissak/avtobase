package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CommentDto {

    Integer id;
    LocalDateTime commentDate;
    Integer mark;
    String message;
}
