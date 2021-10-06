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
public class Driver {

    private Integer id;
    private LocalDateTime doctorStamp;
    private Car car;
    private boolean isBusy; //TODO
    private Comment comment;
}
