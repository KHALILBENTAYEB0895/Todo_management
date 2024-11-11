package ben.code.todo.service;

import ben.code.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAllTodos();
    TodoDto updateTodo(TodoDto todoDto, Long id);
    void deleteTodo(long id);
    TodoDto completeTodo(Long id);
    TodoDto incompleteTodo(Long id);
}
