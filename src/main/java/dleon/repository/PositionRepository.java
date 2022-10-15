package dleon.repository;

import dleon.dto.PositionDto;

import java.util.List;

public interface PositionRepository {
    public List<PositionDto> findPositionForMarkaAndModel(int marka, int model);
}
