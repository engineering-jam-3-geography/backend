package edumaps.app.service;

import edumaps.app.payload.out.TaskPayload;

import java.util.List;

public interface TaskService {

    List<TaskPayload> list();
}
