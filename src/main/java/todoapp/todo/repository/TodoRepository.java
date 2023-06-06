package todoapp.todo.repository;

import org.springframework.data.repository.CrudRepository;
import todoapp.todo.entity.Todo;

import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Optional<Todo> findByTitle(String title);
}
