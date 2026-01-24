package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Serwis zawierający logikę biznesową dotyczącą zadań.
 * Pośredniczy między kontrolerem a repozytorium.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryService categoryService;

    /**
     * Pobiera listę wszystkich zadań.
     * @return Lista wszystkich zadań.
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Tworzy nowe zadanie.
     * Jeśli zadanie ma przypisaną kategorię, sprawdza czy ona istnieje,
     * a jeśli nie - tworzy ją.
     * 
     * @param todo Obiekt zadania do utworzenia.
     * @return Zapisane zadanie.
     */
    public Todo createTodo(Todo todo) {
        if (todo.getCategory() != null && todo.getCategory().getName() != null) {
            Category category = categoryService.getOrCreateCategory(todo.getCategory().getName());
            todo.setCategory(category);
        }
        return todoRepository.save(todo);
    }

    /**
     * Aktualizuje istniejące zadanie.
     * 
     * @param id ID zadania do edycji.
     * @param updatedTodo Obiekt z nowymi danymi zadania.
     * @return Optional zawierający zaktualizowane zadanie lub pusty, jeśli zadanie nie istnieje.
     */
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

    /**
     * Usuwa zadanie o podanym ID.
     * @param id ID zadania do usunięcia.
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
