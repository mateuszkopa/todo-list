package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getOrCreateCategory(String name) {
        return categoryRepository.findByName(name)
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(name);
                    return categoryRepository.save(newCategory);
                });
    }

    public void deleteCategory(Long id) {
        List<Todo> todos = todoRepository.findByCategoryId(id);
        for (Todo todo : todos) {
            todo.setCategory(null);
            todoRepository.save(todo);
        }
        categoryRepository.deleteById(id);
    }
}
