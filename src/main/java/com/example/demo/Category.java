package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Reprezentuje kategorię zadania.
 * <p>
 * Umożliwia grupowanie zadań w logiczne zbiory (np. "Praca", "Dom").
 * Jest encją JPA mapowaną na tabelę w bazie danych.
 * </p>
 */
@Entity
public class Category {
    /**
     * Unikalny identyfikator kategorii.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nazwa kategorii (np. "Zakupy").
     */
    private String name;

    /**
     * Pobiera identyfikator kategorii.
     * @return ID kategorii.
     */
    public Long getId() {
        return id;
    }

    /**
     * Ustawia identyfikator kategorii.
     * @param id Nowe ID kategorii.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pobiera nazwę kategorii.
     * @return Nazwa kategorii.
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwę kategorii.
     * @param name Nowa nazwa kategorii.
     */
    public void setName(String name) {
        this.name = name;
    }
}
