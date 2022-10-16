package dleon.entity;

import dleon.dto.MarkaDto;
import dleon.dto.ModelDto;
import lombok.Data;

@Data
public class PositionEntity {
    private final int id;
    private final MarkaDto markaDto;
    private final ModelDto modelDto;
    private final int yearProduction;
    private final double mileage;
    private final double price;
}
