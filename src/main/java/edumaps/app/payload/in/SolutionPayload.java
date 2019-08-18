package edumaps.app.payload.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import edumaps.app.domain.Answer;
import lombok.Data;

import java.util.List;

@Data
public class SolutionPayload {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("task_id")
    private String taskId;
    private List<Answer> answers;

}
