package com.historicopaciente.historicopaciente.menu;

import com.historicopaciente.historicopaciente.paciente.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Scanner;

@Log4j2
@Component
@RequiredArgsConstructor
public class Menu {

    private final PacienteService pacienteService;

    public void mostrarOpcoesMenu() {
        System.out.println("\n\n -----------------------MENU-----------------------");
        System.out.println("| 1 - Gerar relatório de histórico de paciente     |");
        System.out.println("| 2 - Realizar operação produto cartesiano         |");
        System.out.println("| 3 - Realizar operação união                      |");
        System.out.println("| 4 - Realizar operação diferença                  |");
        System.out.println("| 5 - Realizar operação junção natural a esquerda  |");
        System.out.println("| 6 - Sair                                         |");
        System.out.println(" --------------------------------------------------");
    }

    public int selecionarOpcaoMenu() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a opção desejada: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    public void inicializarMenu() throws FileNotFoundException {
        int opcao = 0;

        while(opcao != 6) {
            mostrarOpcoesMenu();
            opcao = selecionarOpcaoMenu();

            switch (opcao) {
                case 1:
                    System.out.println("\n1 - Gerar relatório de histórico de paciente\n");
                    pacienteService.gerarRelatorioHistoricoPaciente();
                    break;
                case 2:
                    System.out.println("\n2 - Realizar operação produto cartesiano  ");
                    System.out.println("\nSQL -> SELECT * FROM paciente, medico; ");
                    pacienteService.realizarOperacaoProdutoCartesiano();
                    break;
                case 3:
                    System.out.println("\n3 - Realizar operação união");
                    System.out.println("""
                    \n SQL -> SELECT numero_paciente\s
                              
                            FROM consulta_medica\s
                              
                            UNION\s
                              
                            SELECT numero_paciente\s
                              
                            FROM exame_medico;\s
                    """);
                    pacienteService.realizarOperacaoUniao();
                    break;
                case 4:
                    System.out.println("\n4 - Realizar operação diferença  ");
                    System.out.println("""
                    \n SQL -> SELECT numero_paciente\s
                                      
                            FROM exame_medico\s
                                      
                            WHERE numero_paciente\s
                                      
                            NOT IN \s
                                      
                            (SELECT numero_paciente\s
                                      
                            FROM consulta_medica);\s
                    """);
                    pacienteService.realizarOperacaoDiferenca();
                    break;
                case 5:
                    System.out.println("\n5 - Realizar operação junção natural a esquerda");
                    System.out.println("""
                    \n SQL -> SELECT * FROM diagnostico_cid\s
                                      
                            NATURAL LEFT JOIN consulta_medica;\s
                    """);
                    pacienteService.realizarOperacaoJuncaoNaturalEsquerda();
                    break;
                case 6:
                    System.out.println("Saindo do programa...\n\n");
                    return;
                default:
                    System.out.println("Opção inválida, por favor, selecione novamente");
                    break;
            }
        }
    }
}
