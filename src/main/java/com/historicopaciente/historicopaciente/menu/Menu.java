package com.historicopaciente.historicopaciente.menu;

import com.historicopaciente.historicopaciente.paciente.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Log4j2
@Component
@RequiredArgsConstructor
public class Menu {

    private final PacienteService pacienteService;

    public void mostrarOpcoesMenu() {
        System.out.println("\n\n -----------------------MENU-----------------------");
        System.out.println("| 1 - Gerar relatório de histórico de paciente     |");
        System.out.println("| 4 - Sair                                         |");
        System.out.println(" --------------------------------------------------");
    }

    public int selecionarOpcaoMenu() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a opção desejada: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    public void inicializarMenu() {
        int opcao = 0;

        while(opcao != 4) {
            mostrarOpcoesMenu();
            opcao = selecionarOpcaoMenu();

            switch (opcao) {
                case 1:
                    System.out.println("\n1 - Gerar relatório de histórico de paciente");
                    pacienteService.gerarRelatorioHistoricoPaciente();
                    break;
                case 2:
                    System.out.println("Saindo do programa...\n\n");
                    return;
                default:
                    System.out.println("Opção inválida, por favor, selecione novamente");
                    break;
            }
        }
    }
}
