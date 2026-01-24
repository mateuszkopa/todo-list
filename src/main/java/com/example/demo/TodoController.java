package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Kontroler REST obsługujący operacje na zadaniach.
 * Udostępnia endpointy pod adresem /api/todos.
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Pobiera listę wszystkich zadań.
     * Metoda GET /api/todos.
     * 
     * @return Lista wszystkich obiektów Todo.
     */
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    /**
     * Tworzy nowe zadanie.
     * Metoda POST /api/todos.
     * 
     * @param todo Obiekt zadania przesłany w ciele żądania.
     * @return Utworzone zadanie.
     */
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    /**
     * Aktualizuje istniejące zadanie.
     * Metoda PUT /api/todos/{id}.
     * 
     * @param id ID zadania do edycji.
     * @param todo Obiekt z nowymi danymi zadania.
     * @return 200 OK ze zaktualizowanym zadaniem lub 404 Not Found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Usuwa zadanie.
     * Metoda DELETE /api/todos/{id}.
     * 
     * @param id ID zadania do usunięcia.
     * @return 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
