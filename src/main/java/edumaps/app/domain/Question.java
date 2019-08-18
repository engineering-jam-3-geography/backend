package edumaps.app.domain;

import lombok.Data;

import java.util.List;

public @Data class Question {

    private String id;
    private QuestionType type;
    private List<QuestionOption> options;
    private String title;
}
