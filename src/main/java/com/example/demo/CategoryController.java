package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Kontroler REST obsługujący operacje na kategoriach.
 * Udostępnia endpointy pod adresem /api/categories.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Pobiera listę wszystkich kategorii.
     * Metoda GET /api/categories.
     * 
     * @return Lista kategorii.
     */
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Usuwa kategorię o podanym ID.
     * Metoda DELETE /api/categories/{id}.
     * 
     * @param id ID kategorii do usunięcia.
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
