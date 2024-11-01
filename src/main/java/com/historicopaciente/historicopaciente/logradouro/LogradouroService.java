package com.historicopaciente.historicopaciente.logradouro;

import com.historicopaciente.historicopaciente.tipologradouro.TipoLogradouroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LogradouroService {

    private final LogradouroRepository logradouroRepository;
    private final TipoLogradouroService tipoLogradouroService;

    public Logradouro lerLogradouro() {
        Scanner scanner = new Scanner(System.in);
        Logradouro logradouro = new Logradouro();

        System.out.print("Logradouro: ");
        logradouro.setNome(scanner.nextLine());

        logradouro.setTipoLogradouro(tipoLogradouroService.lerTipoLogradouro());

        return logradouroRepository.save(logradouro);
    }
}
