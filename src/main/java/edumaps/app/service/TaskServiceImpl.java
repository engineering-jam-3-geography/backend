package edumaps.app.service;

import edumaps.app.domain.Task;
import edumaps.app.payload.out.TaskPayload;
import edumaps.app.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TaskServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public List<TaskPayload> list() {
        List<TaskPayload> result = new ArrayList<>();
        tasksRepository.findAll().forEach(el -> {
            result.add(toPayload(el));
        });
        return result;
    }

    private TaskPayload toPayload(Task task) {
        return new TaskPayload(task.getId(), task.getDescription(), task.getContent(), task.getLevel(), task.getVisuals(), task.getInteractions());
    }
}
