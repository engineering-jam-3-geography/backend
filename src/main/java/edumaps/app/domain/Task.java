package edumaps.app.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String description;
    private Content content;
    private Byte level;
    private List<Visual> visuals;
    private List<Interaction> interactions;
    private List<Answer> definedAnswers;
}
