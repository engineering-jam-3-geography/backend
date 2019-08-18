package edumaps.app.service;

import edumaps.app.domain.Answer;
import edumaps.app.domain.Progress;
import edumaps.app.domain.Solution;
import edumaps.app.domain.Task;
import edumaps.app.repository.SolutionsRepository;
import edumaps.app.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SolutionEvaluationServiceImpl implements SolutionEvaluationService {

    private final TasksRepository tasksRepository;
    private final SolutionsRepository solutionsRepository;


    @Autowired
    private ApplicationContext ctx;

    @Autowired
    public SolutionEvaluationServiceImpl(TasksRepository tasksRepository, SolutionsRepository solutionsRepository) {
        this.tasksRepository = tasksRepository;
        this.solutionsRepository = solutionsRepository;
    }

    @Override
    public Progress evaluate(String solutionId) {
        Solution solution = solutionsRepository.findOne(solutionId);
        Progress progress = new Progress();
        Task task = tasksRepository.findOne(solution.getTaskId());
        progress.setTotal(((Integer) task.getDefinedAnswers().size()).byteValue());
        byte right = 0;
        for (Answer answer : solution.getAnswers()) {
            AnswerEvaluator evaluator =
                    BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx.getAutowireCapableBeanFactory(),
                            AnswerEvaluator.class, answer.getType().name());
            if (evaluator.evaluate(task, answer)) {
                right++;
            }
        }
        progress.setRight(right);
        return progress;
    }
}
