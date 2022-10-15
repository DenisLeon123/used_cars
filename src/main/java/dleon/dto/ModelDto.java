package dleon.dto;

import lombok.Data;

@Data
public class ModelDto {
    private final String name;
    private final int dateOfStartProduction;
    private final int dateOfEndProduction;
}
