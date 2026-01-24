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

    public Optional<Todo> updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setContent(updatedTodo.getContent());
            todo.setPriority(updatedTodo.getPriority());
            todo.setDeadline(updatedTodo.getDeadline());
            todo.setCompleted(updatedTodo.isCompleted());
            
            if (updatedTodo.getCategory() != null && updatedTodo.getCategory().getName() != null) {
                Category category = categoryService.getOrCreateCategory(updatedTodo.getCategory().getName());
                todo.setCategory(category);
            } else {
                todo.setCategory(null);
            }
            
            return todoRepository.save(todo);
        });
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
