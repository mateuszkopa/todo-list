# Specyfikacja Wymagań - Organizer Zadań (Web To-Do List)

Projekt realizowany w ramach przedmiotu Programowanie Obiektowe. Aplikacja jest serwisem internetowym służącym do zarządzania listą zadań z uwzględnieniem priorytetów, kategorii oraz terminów realizacji.

## 1. Zarządzanie Zadaniami (Logika Biznesowa)
Podstawowe operacje na obiektach zadań (Backend).
- [ ] **Tworzenie zadania:** Przetwarzanie danych z formularza i utworzenie obiektu zadania.
- [ ] **Edycja zadania:** Możliwość zmiany parametrów istniejącego zadania.
- [ ] **Usuwanie zadania:** Usunięcie zadania z bazy danych/pliku na podstawie ID.
- [ ] **Zmiana statusu:** Logika obsugi oznaczania zadania jako "Wykonane" (Done).

## 2. Atrybuty i Model Danych
Szczegółowe właściwości obiektów.
- [ ] **Priorytety:** Obsługa typu wyliczeniowego: *High, Medium, Low*.
- [ ] **Kategorie:** Przypisywanie etykiet do zadań (np. *Praca, Dom, Studia*).
- [ ] **Terminy (Deadline):** Przechowywanie i formatowanie daty wykonania.
- [ ] **Walidacja (Backend):** Sprawdzanie poprawności danych przesyłanych przez formularz (np. czy data nie jest pusta).

## 3. Przeglądanie i Organizacja
Logika przygotowania danych dla widoku.
- [ ] **Filtrowanie listy:** Metody zwracające podzbiór zadań (np. tylko "Do zrobienia").
- [ ] **Sortowanie:** Sortowanie listy zadań po dacie lub priorytecie przed wysłaniem do widoku.

## 4. Trwałość Danych (Persistence)
- [ ] **Repozytorium:** Warstwa odpowiedzialna za zapis i odczyt danych.
    * MySQL.

## 5. Interfejs Webowy (Frontend)
Warstwa wizualna oparta o HTML/CSS.
- [ ] **Strona Główna (Dashboard):** Wyświetla listę wszystkich zadań w formie tabeli lub kafelków.
- [ ] **Formularz Dodawania:** Strona z polami: Tytuł, Opis, Kategoria, Priorytet, Data.
- [ ] **Interakcje:**
    - [ ] Przycisk "Usuń" przy każdym zadaniu.
    - [ ] Checkbox lub przycisk do zmiany statusu na "Wykonane".
    - [ ] Wizualne wyróżnienie priorytetów (np. kolor czerwony dla "High").
