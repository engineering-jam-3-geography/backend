package edumaps.app.payload.out;

import edumaps.app.domain.Content;
import edumaps.app.domain.Interaction;
import edumaps.app.domain.Visual;
import lombok.Data;

import java.util.List;

public @Data class TaskPayload {

    public TaskPayload(String id, String description, Content content, Byte level, List<Visual> visuals, List<Interaction> interactions) {
        this.id = id;
        this.description = description;
        this.content = content;
        this.level = level;
        this.visuals = visuals;
        this.interactions = interactions;
    }

    private String id;
    private String description;
    private Content content;
    private Byte level;
    private List<Visual> visuals;
    private List<Interaction> interactions;

}
