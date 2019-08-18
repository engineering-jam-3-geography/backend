package edumaps.app.service;

import edumaps.app.domain.Progress;

public interface SolutionEvaluationService {

    Progress evaluate(String solutionId);

}
