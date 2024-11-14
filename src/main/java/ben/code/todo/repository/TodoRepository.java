package ben.code.todo.repository;

import ben.code.todo.entity.Todo;
import ben.code.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
