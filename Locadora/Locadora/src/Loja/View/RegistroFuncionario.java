package Loja.View;

import java.util.Scanner;

import Loja.Modelos.Funcionario;

import java.util.List;

public class RegistroFuncionario {

    static String nomeIndividuo; // informacoes gerais para registrar nomes, cpf e cargos
    static String cargo;
    static String cpf;
    static Scanner scannerInteiro = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void registroFuncionarioFunc(List<Funcionario> listaFuncionariosTemp){
        System.out.println("DIGITE O NOME:");
        nomeIndividuo = scannerString.nextLine();
        System.out.println("DIGITE O CPF:");
        cpf = scannerString.nextLine();
        System.out.println("DIGITE O CARGO:"); // talvez mudar esse sistema para o usuario escolher algum cargo pre-estabelecido para facilitar a atribuição no banco de dados na 2a parte do projeto
        cargo = scannerString.nextLine();
        Funcionario funcionario = new Funcionario(nomeIndividuo, cpf, cargo);
        listaFuncionariosTemp.add(funcionario);
        System.out.println("FUNCIONARIO ADICIONADO COM SUCESSO");
    }
}
