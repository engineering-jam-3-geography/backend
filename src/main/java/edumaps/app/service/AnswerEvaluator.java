package edumaps.app.service;

import edumaps.app.domain.Answer;
import edumaps.app.domain.Task;

public interface AnswerEvaluator {

    boolean evaluate(Task task, Answer answer);

}
