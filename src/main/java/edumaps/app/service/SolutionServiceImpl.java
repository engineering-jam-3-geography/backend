package edumaps.app.service;

import edumaps.app.domain.Solution;
import edumaps.app.payload.in.SolutionPayload;
import edumaps.app.repository.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionServiceImpl implements SolutionService {

    private final SolutionsRepository solutionsRepository;

    @Autowired
    public SolutionServiceImpl(SolutionsRepository solutionsRepository) {
        this.solutionsRepository = solutionsRepository;
    }

    @Override
    public String save(SolutionPayload solutionPayload) {
        Solution solution = toDomain(solutionPayload);
        return solutionsRepository.save(solution).getId();
    }

    private Solution toDomain(SolutionPayload solutionPayload) {
        return new Solution(solutionPayload.getUserId(), solutionPayload.getTaskId(), solutionPayload.getAnswers());
    }
}
