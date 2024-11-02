package com.historicopaciente.historicopaciente;

import com.historicopaciente.historicopaciente.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HistoricoPacienteApplication implements CommandLineRunner {

    private final Menu menu;

    public static void main(String[] args) {
        SpringApplication.run(HistoricoPacienteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.inicializarMenu();
    }
}
