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

    // Zapisuje zadanie (dodaje nowe lub aktualizuje istniejące)
    public Todo saveTodo(Todo todo) {

        if (todo.getCategory() != null && todo.getCategory().getName() != null && !todo.getCategory().getName().isEmpty()) {
            
            String categoryName = todo.getCategory().getName();

            Category category = categoryService.getOrCreateCategory(categoryName);
            
            todo.setCategory(category);
        }

        return todoRepository.save(todo);
    }


    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }


    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
}
