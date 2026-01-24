package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Główna klasa startowa aplikacji Spring Boot.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Metoda uruchamiająca aplikację.
	 * 
	 * @param args Argumenty wiersza poleceń.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
