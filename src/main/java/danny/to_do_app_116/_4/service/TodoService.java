package danny.to_do_app_116._4.service;

import danny.to_do_app_116._4.entity.Todo;
import danny.to_do_app_116._4.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Create
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Read
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // Update
    public Todo updateTodo(Todo todo) {
        if (todoRepository.existsById(todo.getId())) {
            return todoRepository.save(todo);
        }
        throw new RuntimeException("Todo not found with id: " + todo.getId());
    }

    // Delete
    public void deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
    }
}
