package dleon.dto;

import lombok.Data;

@Data
public class PositionDto {
    private final MarkaDto markaDto;
    private final ModelDto modelDto;
    private final int yearProduction;
    private final double mileage;
    private final double price;
}
