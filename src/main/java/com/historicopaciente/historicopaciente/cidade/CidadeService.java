package com.historicopaciente.historicopaciente.cidade;

import com.historicopaciente.historicopaciente.unidadefederativa.UnidadeFederativa;
import com.historicopaciente.historicopaciente.unidadefederativa.UnidadeFederativaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;
    private final UnidadeFederativaService unidadeFederativaService;


    public Cidade lerCidade() {
        Scanner scanner = new Scanner(System.in);

        UnidadeFederativa unidadeFederativa = unidadeFederativaService.lerUnidadeFederativa();
        imprimirCidades(unidadeFederativa);

        System.out.print("Nome da cidade: ");
        String nomeCidade = scanner.nextLine();

        while(!cidadeRepository.existsByNomeCidade(nomeCidade)) {
            System.out.print("Selecione uma cidade existente: ");
            nomeCidade = scanner.nextLine();
        }

        return cidadeRepository.findByNomeCidade(nomeCidade);

    }

    private List<Cidade> buscarTodasCidadesPorUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        return cidadeRepository.findAllByUnidadeFederativa(unidadeFederativa);
    }

    public void imprimirCidades(UnidadeFederativa unidadeFederativa) {
        List<Cidade> cidadeList = buscarTodasCidadesPorUnidadeFederativa(unidadeFederativa);

        if (cidadeList.isEmpty()) {
            System.out.println("Nenhuma cidade encontrada.");
            return;
        }

        System.out.println("\n ---------------------------Cidades---------------------------");
        for (Cidade cidade : cidadeList) {
            System.out.println(formatarCidade(cidade));
        }
        System.out.println(" -------------------------------------------------------------");
    }

    private String formatarCidade(Cidade cidade) {
        return String.format("| Cidade: %-20s  UF: %-20s (%s) |",
                cidade.getNome(),
                cidade.getUnidadeFederativa().getNome(),
                cidade.getUnidadeFederativa().getSigla());
    }
}
