package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Serwis zawierający logikę biznesową dotyczącą kategorii.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    /**
     * Pobiera listę wszystkich dostępnych kategorii.
     * @return Lista kategorii.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Pobiera istniejącą kategorię o podanej nazwie lub tworzy nową, jeśli taka nie istnieje.
     * 
     * @param name Nazwa kategorii.
     * @return Znaleziona lub nowo utworzona kategoria.
     */
    public Category getOrCreateCategory(String name) {
        return categoryRepository.findByName(name)
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(name);
                    return categoryRepository.save(newCategory);
                });
    }

    /**
     * Usuwa kategorię o podanym ID.
     * Przed usunięciem kategorii, odłącza ją od wszystkich powiązanych zadań,
     * aby zapobiec naruszeniu integralności danych lub usunięciu zadań.
     * 
     * @param id ID kategorii do usunięcia.
     */
    public void deleteCategory(Long id) {
        List<Todo> todos = todoRepository.findByCategoryId(id);
        for (Todo todo : todos) {
            todo.setCategory(null);
            todoRepository.save(todo);
        }
        categoryRepository.deleteById(id);
    }
}
