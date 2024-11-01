package com.historicopaciente.historicopaciente.tipologradouro;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class TipoLogradouroService {

    private final TipoLogradouroRepository tipoLogradouroRepository;

    public TipoLogradouro lerTipoLogradouro() {
        Scanner scanner = new Scanner(System.in);

        imprimirTiposLogradouro();

        System.out.print("Sigla do tipo de logradouro (informe a sigla):");
        String siglaTipoLogradouro = scanner.nextLine();

        while(!tipoLogradouroRepository.existsBySiglaTipoLogradouro(siglaTipoLogradouro)) {
            System.out.print("Selecione um tipo de logradouro existente (informe a sigla):");
            siglaTipoLogradouro = scanner.nextLine();
        }

        return tipoLogradouroRepository.findBySiglaTipoLogradouro(siglaTipoLogradouro);
    }

    public void imprimirTiposLogradouro() {
        List<TipoLogradouro> tiposLogradouro = buscarTodosTiposLogradouro();

        if (tiposLogradouro.isEmpty()) {
            System.out.println("Nenhum tipo de logradouro encontrado.");
            return;
        }

        System.out.println("\n --------Tipos de Logradouro--------");
        for (TipoLogradouro tipo : tiposLogradouro) {
            System.out.println(formatarTipoLogradouro(tipo));
        }
        System.out.println(" -----------------------------------");
    }

    public List<TipoLogradouro> buscarTodosTiposLogradouro() {
        return tipoLogradouroRepository.findAll();
    }

    private String formatarTipoLogradouro(TipoLogradouro tipoLogradouro) {
        return String.format("| Sigla: %-10s Nome: %-10s| ",
                tipoLogradouro.getSigla(),
                tipoLogradouro.getNome());
    }
}
