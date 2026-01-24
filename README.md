# Organizer Zadań (To-Do List)

Prosta i funkcjonalna aplikacja webowa do zarządzania zadaniami, stworzona w ramach projektu zaliczeniowego z Programowania Obiektowego. Aplikacja pozwala na tworzenie, edycję, usuwanie i organizowanie zadań w kategorie, z uwzględnieniem priorytetów i terminów realizacji.

## Możliwości i Funkcje

### Zarządzanie Zadaniami
*   **Dodawanie zadań:** Szybkie tworzenie zadań z określeniem treści, daty wykonania, priorytetu i kategorii.
*   **Edycja statusu:** Oznaczanie zadań jako wykonane (checkbox).
*   **Usuwanie:** Trwałe usuwanie niepotrzebnych zadań.

###  Organizacja i Filtrowanie
*   **Kategorie:**
    *   Tworzenie własnych kategorii (np. Praca, Dom, Zakupy).
    *   Filtrowanie zadań po wybranej kategorii.
    *   Usuwanie kategorii (zadania tracą przypisanie, ale nie są usuwane).
*   **Priorytety:** Trzystopniowa skala priorytetów (P1 - Wysoki, P2 - Średni, P3 - Niski) z wizualnym rozróżnieniem kolorystycznym.
*   **Widoki Czasowe:**
    *   **Wszystkie:** Pełna lista zadań.
    *   **Dziś:** Zadania z terminem na bieżący dzień.
    *   **Nadchodzące:** Plan na najbliższe 7 dni z podziałem na dni tygodnia.
*   **Filtrowanie zaawansowane:** Możliwość jednoczesnego filtrowania po kategorii i priorytecie.

### Interfejs Użytkownika (UI/UX)
*   **Responsywny design:** Estetyczny i czytelny interfejs.
*   **Tryb Ciemny (Dark Mode):** Wbudowana obsługa motywu jasnego i ciemnego z zapisem preferencji.
*   **Dynamiczny pasek boczny:** Możliwość zwijania menu bocznego dla większej przestrzeni roboczej.

##  Technologia

Projekt został zrealizowany w architekturze klient-serwer.

### Backend (Serwer)
*   **Język:** Java 25
*   **Framework:** Spring Boot 4.0.1
*   **Baza Danych:** MariaDB (uruchamiana w kontenerze Docker)
*   **ORM:** Hibernate / Spring Data JPA
*   **Build Tool:** Gradle

### Frontend (Klient)
*   **HTML5 & CSS3** (Custom properties, Flexbox)
*   **JavaScript (Vanilla JS)** - komunikacja z API (Fetch API), obsługa DOM.

## Wymagania wstępne

Aby uruchomić projekt lokalnie, potrzebujesz:
*   **Docker** oraz **Docker Compose** (do uruchomienia bazy danych).
*   System operacyjny Linux/macOS (do skryptu `run.sh`) lub Windows (wymaga manualnego uruchomienia Dockera).
*   *Opcjonalnie:* JDK 25 (jeśli chcesz budować projekt ręcznie bez wrappera Gradle).

## Uruchomienie aplikacji

W katalogu głównym projektu znajduje się skrypt pomocniczy, który automatycznie stawia bazę danych i uruchamia aplikację.

### Metoda automatyczna (Linux/macOS)
Uruchom skrypt `run.sh`:
```bash
./run.sh
```
Skrypt ten:
1.  Uruchomi kontener z bazą MariaDB.
2.  Odczeka na inicjalizację bazy.
3.  Uruchomi aplikację Spring Boot.
4.  Po zakończeniu (Ctrl+C) posprząta (zatrzyma kontenery).

### Metoda ręczna

1.  **Uruchom bazę danych:**
    ```bash
    cd mariadb
    docker-compose up -d
    cd ..
    ```
2.  **Uruchom aplikację:**
    ```bash
    ./gradlew bootRun
    ```

Aplikacja będzie dostępna pod adresem: **http://localhost:8080**

## Testy

Aby uruchomić testy jednostkowe/integracyjne (korzystają z wbudowanej bazy H2):
```bash
./gradlew test
```

## Struktura Projektu

*   `src/main/java` - Kod źródłowy backendu (Kontrolery, Serwisy, Encje).
*   `src/main/resources` - Konfiguracja (`application.properties`) oraz pliki statyczne frontendu (`static/`).
*   `mariadb/` - Konfiguracja Docker Compose dla bazy danych.
[![Diagram UML](https://iili.io/f6o0Bx1.md.jpg)](https://freeimage.host/i/f6o0Bx1)
