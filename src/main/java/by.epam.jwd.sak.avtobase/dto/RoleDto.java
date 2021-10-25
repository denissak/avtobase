package by.epam.jwd.sak.avtobase.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleDto {

    Long id;
    String name;
}
