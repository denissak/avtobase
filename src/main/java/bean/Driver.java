package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    private Integer id;
    private Integer priceKm;
    private Integer priceHour;
    private String doctorStamp;
    private Car car;
    //private boolean isBusy;
    private Comment comment;
}
