package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Interfejs repozytorium dla encji {@link Category}.
 * <p>
 * Umożliwia dostęp do danych kategorii w bazie danych.
 * </p>
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    /**
     * Wyszukuje kategorię na podstawie jej nazwy.
     * 
     * @param name Nazwa szukanej kategorii.
     * @return Opcjonalna (Optional) kategoria, jeśli została znaleziona.
     */
    Optional<Category> findByName(String name);
}
