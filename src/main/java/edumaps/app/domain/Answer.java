package edumaps.app.domain;

import lombok.Data;

import java.util.Map;

@Data
public class Answer {

    private InteractionType type;
    private Map<String, String> value;

}
