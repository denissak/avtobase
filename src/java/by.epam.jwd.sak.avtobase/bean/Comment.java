package by.epam.jwd.sak.avtobase.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Comment {

    private Integer id;
    private LocalDateTime commentDate;
    private Integer mark;
    private String message;

}
