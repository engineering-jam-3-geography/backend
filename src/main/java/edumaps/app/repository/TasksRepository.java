package edumaps.app.repository;

import edumaps.app.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, String> {
}
