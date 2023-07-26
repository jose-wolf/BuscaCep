package Executavel;

import Modelo.ConsultaCep;
import Modelo.Endereco;
import Modelo.GeradorDeArquivos;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var cep = "";

        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("digite algum CEP");
        cep = scanner.nextLine();

        while(!cep.equalsIgnoreCase("sair")) {

            if(cep.equalsIgnoreCase("sair")){
                break;
            }

            try {
                Endereco novoEndereco = consultaCep.buscarCep(cep);
                GeradorDeArquivos gerarArquivo = new GeradorDeArquivos();
                gerarArquivo.gerarArquivoJson(novoEndereco);
                System.out.println(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("digite algum CEP. Para sair, digite: \"sair\"");
            cep = scanner.nextLine();
        }

        System.out.println("Finalizando");

    }
}
