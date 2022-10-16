package dleon.service;

import dleon.dto.PositionFoundDto;
import dleon.entity.PositionEntity;
import dleon.executor.PostExecutionContext;
import dleon.repository.PositionRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.ibatis.session.SqlSession;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static dleon.factory.SqlSessionFactoryManual.getSessionFactory;

public class MarkService {

    private final PostExecutionContext ec;

    @Inject
    public MarkService(PostExecutionContext ec) {
        this.ec = ec;
    }

    public CompletableFuture<List<PositionEntity>> findPosition(PositionFoundDto positionFoundDto) {
        return supplyAsync(
                () -> {
                    SqlSession session = getSessionFactory().openSession();
                    PositionRepository positionRepository = session.getMapper(PositionRepository.class);
                    return positionRepository
                            .findPositionForMarkaAndModel(positionFoundDto.getMarkaDto(),
                                    positionFoundDto.getModelDto());
                }, ec);
    }
}
