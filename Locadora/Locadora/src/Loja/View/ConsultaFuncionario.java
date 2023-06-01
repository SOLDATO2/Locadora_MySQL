package Loja.View;

import java.util.List;

import Loja.Modelos.Funcionario;

public class ConsultaFuncionario { // falta gerar consulta funcionario DAO
    public static void consultaFuncionarioFunc(List<Funcionario> listaFuncionariosTemp){
        if(listaFuncionariosTemp.isEmpty()){
                    
            System.out.println("Não existe nenhum funcionario registrado");

        }else{
            for (Funcionario item : listaFuncionariosTemp){ // esse é um for mais complexo (for each), daria pra fazer com for simples tmb.
                System.out.println("----------------------------------------------------------");
                System.out.println("Nome funcionario: " + item.getNomePessoa());
                System.out.println("Nome CPF: " + item.getCpfPessoa());
                System.out.println("Nome cargo: " + item.getCargo());
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}
