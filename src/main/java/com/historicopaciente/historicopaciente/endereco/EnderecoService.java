package com.historicopaciente.historicopaciente.endereco;

import com.historicopaciente.historicopaciente.bairro.BairroService;
import com.historicopaciente.historicopaciente.cidade.CidadeService;
import com.historicopaciente.historicopaciente.logradouro.LogradouroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final LogradouroService logradouroService;
    private final CidadeService cidadeService;
    private final BairroService bairroService;

    public Endereco lerEndereco() {
        Scanner scanner = new Scanner(System.in);
        Endereco endereco = new Endereco();

        System.out.print("CEP:");
        endereco.setCep(scanner.nextLine());

        endereco.setLogradouro(logradouroService.lerLogradouro());

        endereco.setCidade(cidadeService.lerCidade());

        endereco.setBairro(bairroService.lerBairro());

        return enderecoRepository.save(endereco);
    }

    public String gerarEnderecoCompleto(Endereco endereco, String complementoEndereco, String numeroEndereco) {
        StringBuilder enderecoCompleto = new StringBuilder();

        if (endereco.getLogradouro() != null) {
            if (endereco.getLogradouro().getTipoLogradouro() != null) {
                enderecoCompleto.append(endereco.getLogradouro().getTipoLogradouro().getSigla()).append(" ");
            }
            enderecoCompleto.append(endereco.getLogradouro().getNome()).append(", ");
        }

        enderecoCompleto.append("Nº ").append(numeroEndereco).append(", ");

        if (complementoEndereco != null && !complementoEndereco.isEmpty()) {
            enderecoCompleto.append(complementoEndereco).append(", ");
        }

        if (endereco.getBairro() != null) {
            enderecoCompleto.append(endereco.getBairro().getNome()).append(", ");
        }

        if (endereco.getCidade() != null) {
            enderecoCompleto.append(endereco.getCidade().getNome());

            if (endereco.getCidade().getUnidadeFederativa() != null) {
                enderecoCompleto.append(" - ").append(endereco.getCidade().getUnidadeFederativa().getSigla());
            }
            enderecoCompleto.append(", ");
        }

        enderecoCompleto.append("CEP: ").append(endereco.getCep());

        return enderecoCompleto.toString();
    }

//    public void mostrarEnderecoCliente(Cliente cliente) {
//        Endereco endereco = cliente.getEndereco();
//
//        if (endereco != null) {
//            System.out.println("Endereço:");
//            System.out.println("   Rua: " + endereco.getLogradouro().getNomeLogradouro() + ", " + cliente.getNumeroEndereco() + " - " + cliente.getComplementoEndereco());
//            System.out.println("   Bairro: " + endereco.getBairro().getNomeBairro());
//            System.out.println("   Cidade: " + endereco.getCidade().getNomeCidade() + " - " + endereco.getCidade().getUnidadeFederativa().getSiglaUF());
//            System.out.println("   CEP: " + endereco.getCep());
//            System.out.println("   Complemento: " + cliente.getComplementoEndereco());
//            System.out.println("   Número: " + cliente.getNumeroEndereco());
//        } else {
//            System.out.println("Endereço não cadastrado.");
//        }
//    }
}
