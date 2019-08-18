package edumaps.app.resource;

import edumaps.app.payload.out.TaskPayload;
import edumaps.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Component
@Path("/tasks")
@Produces("application/json")
public class TaskResource {

    private final TaskService taskService;

    @Autowired
    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    public List<TaskPayload> getTasks() {
        return taskService.list();
    }
}
