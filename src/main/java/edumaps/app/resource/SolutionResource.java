package edumaps.app.resource;

import edumaps.app.domain.Progress;
import edumaps.app.payload.in.SolutionPayload;
import edumaps.app.service.SolutionEvaluationService;
import edumaps.app.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/solutions")
@Consumes("application/json")
@Produces("application/json")
public class SolutionResource {

    private final SolutionService solutionService;
    private final SolutionEvaluationService solutionEvaluationService;

    @Autowired
    public SolutionResource(SolutionService solutionService, SolutionEvaluationService solutionEvaluationService) {
        this.solutionService = solutionService;
        this.solutionEvaluationService = solutionEvaluationService;
    }

    @POST
    public Progress saveSolution(@RequestBody SolutionPayload solutionPayload) {
        String solutionId = solutionService.save(solutionPayload);
        return solutionEvaluationService.evaluate(solutionId);
    }
}
