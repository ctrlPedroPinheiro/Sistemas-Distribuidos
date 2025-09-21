package br.edu.iff.sistemasdistribuidos.calculofinanceiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching; // <-- Importar

@SpringBootApplication
@EnableCaching 
public class CalculoFinanceiroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculoFinanceiroServiceApplication.class, args);
    }
}