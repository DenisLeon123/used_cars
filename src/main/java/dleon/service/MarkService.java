package dleon.service;

import dleon.dto.PositionDto;
import dleon.dto.PositionFoundDto;
import dleon.executor.PostExecutionContext;
import dleon.repository.PositionRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class MarkService {


    private final PositionRepository positionRepository;
    private final PostExecutionContext ec;

    @Inject
    public MarkService(PositionRepository positionRepository, PostExecutionContext ec) {
        this.positionRepository = positionRepository;
        this.ec = ec;
    }

    public CompletableFuture<List<PositionDto>> findPosition(PositionFoundDto positionFoundDto) {
        return supplyAsync(
                () -> positionRepository
                        .findPositionForMarkaAndModel(positionFoundDto.getMarkaDto(),
                                positionFoundDto.getModelDto()),
                ec);
    }
}
