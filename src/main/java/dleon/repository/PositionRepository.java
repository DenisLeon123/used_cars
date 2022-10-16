package dleon.repository;

import dleon.entity.PositionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PositionRepository {
    @Select("SELECT * FROM cars_position WHERE c_marka = #{marka} and c_model = #{model}")
    List<PositionEntity> findPositionForMarkaAndModel(int marka, int model);
}
