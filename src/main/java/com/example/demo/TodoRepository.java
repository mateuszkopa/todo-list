package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interfejs repozytorium dla encji {@link Todo}.
 * <p>
 * Rozszerza {@link JpaRepository}, zapewniając podstawowe operacje CRUD
 * oraz metody do wyszukiwania zadań.
 * </p>
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    /**
     * Znajduje wszystkie zadania przypisane do danej kategorii.
     * 
     * @param categoryId ID kategorii, dla której szukamy zadań.
     * @return Lista zadań należących do kategorii o podanym ID.
     */
    List<Todo> findByCategoryId(Long categoryId);
}
