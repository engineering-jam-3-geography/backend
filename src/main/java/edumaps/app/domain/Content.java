package edumaps.app.domain;

import lombok.Data;

import java.util.List;

public @Data class Content {

    private String id;
    private String markup;
    private List<Question> questions;
}
