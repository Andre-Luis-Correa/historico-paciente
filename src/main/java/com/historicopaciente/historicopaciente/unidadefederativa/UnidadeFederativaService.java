package com.historicopaciente.historicopaciente.unidadefederativa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class UnidadeFederativaService {

    private final UnidadeFederativaRepository unidadeFederativaRepository;

    public UnidadeFederativa lerUnidadeFederativa() {
        Scanner scanner = new Scanner(System.in);

        imprimirUnidadesFederativas();

        System.out.print("Sigla da unidade federativa (UF): ");
        String siglaUF = scanner.nextLine();

        while(!unidadeFederativaRepository.existsBySiglaUF(siglaUF)) {
            System.out.print("Selecione um estado existente (informe a sigla UF): ");
            siglaUF = scanner.nextLine();
        }

        return unidadeFederativaRepository.findBySiglaUF(siglaUF);
    }

    public void imprimirUnidadesFederativas() {
        List<UnidadeFederativa> unidadesFederativas = buscarTodasUnidadesFederativas();

        if (unidadesFederativas.isEmpty()) {
            System.out.println("Nenhuma unidade federativa encontrada.");
            return;
        }

        System.out.println("\n --------------Unidades Federativas-------------");
        for (UnidadeFederativa uf : unidadesFederativas) {
            System.out.println(formatarUnidadeFederativa(uf));
        }
        System.out.println(" -----------------------------------------------");
    }

    private List<UnidadeFederativa> buscarTodasUnidadesFederativas() {
        return unidadeFederativaRepository.findAll();
    }

    private String formatarUnidadeFederativa(UnidadeFederativa uf) {
        return String.format("| Sigla: %-10s  Nome: %-20s |",
                uf.getSigla(),
                uf.getNome());
    }
}
