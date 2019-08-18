package edumaps.app.repository;

import edumaps.app.domain.Solution;
import org.springframework.data.repository.CrudRepository;

public interface SolutionsRepository extends CrudRepository<Solution, String> {
}
