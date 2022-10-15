package dleon.controllers;

import dleon.dto.PositionFoundDto;
import play.core.j.HttpExecutionContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import dleon.service.MarkService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class MarkController extends Controller {

    private HttpExecutionContext ec;
    private MarkService service;

    @Inject
    public MarkController(HttpExecutionContext ec, MarkService service) {
        this.ec = ec;
        this.service = service;
    }

    public CompletionStage getCarOfMarkList(Http.Request request, PositionFoundDto positionFoundDto) {
        return service.findPosition(positionFoundDto).thenApplyAsync(position -> {
            return ok(Json.toJson(position));
        });
    }
}
