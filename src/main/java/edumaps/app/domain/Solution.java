package edumaps.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "solutions")
public class Solution {

    @Id
    private String id;
    private String userId;
    private String taskId;
    private List<Answer> answers;

    public Solution(String userId, String taskId, List<Answer> answers) {
        this.userId = userId;
        this.taskId = taskId;
        this.answers = answers;
    }
}
