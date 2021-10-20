package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class DriverRequest implements Serializable {

    private Integer driverId;
    private Integer requestsId;
}
