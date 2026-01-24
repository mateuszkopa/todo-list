package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Reprezentuje pojedyncze zadanie (Todo) w systemie.
 * <p>
 * Klasa ta jest encją JPA mapowaną na tabelę w bazie danych.
 * Przechowuje informacje takie jak treść zadania, priorytet,
 * termin wykonania, status ukończenia oraz przypisaną kategorię.
 * </p>
 */
@Entity
public class Todo {

    /**
     * Unikalny identyfikator zadania.
     * Generowany automatycznie przez bazę danych.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Treść lub opis zadania.
     */
    private String content;

    /**
     * Kategoria, do której przypisane jest zadanie.
     * Relacja wiele-do-jednego z encją {@link Category}.
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Priorytet zadania.
     * Zazwyczaj przyjmuje wartości: 1 (Wysoki), 2 (Średni), 3 (Niski).
     */
    private Integer priority; // 1, 2, 3

    /**
     * Data, do której zadanie powinno zostać wykonane.
     */
    private LocalDate deadline;

    /**
     * Status ukończenia zadania.
     * Wartość true oznacza zadanie wykonane.
     */
    private boolean completed;

    // Getters and Setters

    /**
     * Pobiera identyfikator zadania.
     * @return ID zadania.
     */
    public Long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator zadania.
     * @param id Nowe ID zadania.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pobiera treść zadania.
     * @return Treść zadania.
     */
    public String getContent() {
        return content;
    }

    /**
     * Ustawia treść zadania.
     * @param content Nowa treść zadania.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Pobiera kategorię zadania.
     * @return Kategoria zadania.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Przypisuje kategorię do zadania.
     * @param category Nowa kategoria.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Pobiera priorytet zadania.
     * @return Priorytet (zazwyczaj 1-3).
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Ustawia priorytet zadania.
     * @param priority Nowy priorytet.
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Pobiera termin wykonania zadania.
     * @return Data deadline'u.
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * Ustawia termin wykonania zadania.
     * @param deadline Nowa data deadline'u.
     */
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    /**
     * Sprawdza, czy zadanie jest ukończone.
     * @return true jeśli ukończone, false w przeciwnym razie.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Ustawia status ukończenia zadania.
     * @param completed true aby oznaczyć jako wykonane.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
