package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        if (todo.getCategory() != null && todo.getCategory().getName() != null) {
            Category category = categoryService.getOrCreateCategory(todo.getCategory().getName());
            todo.setCategory(category);
        }
        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodoStatus(Long id, boolean completed) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(completed);
            todoRepository.save(todo);
        }
        return todoOptional;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
