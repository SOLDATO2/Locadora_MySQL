package Loja.View;


import Loja.Modelos.Funcionario;
import Loja.DAO.ConsultaFuncionarioDAO;

public class ConsultaFuncionario { // falta gerar consulta funcionario DAO
    public static void consultaFuncionarioFunc(){
       



        ConsultaFuncionarioDAO consultaFuncionario = new ConsultaFuncionarioDAO();

        for(Funcionario funcionario : consultaFuncionario.getFuncionario()){
            System.out.println("----------------------------------------------------------");
            System.out.println("Nome funcionario: " + funcionario.getNomePessoa());
            System.out.println("Nome CPF: " + funcionario.getCpfPessoa());
            System.out.println("Nome cargo: " + funcionario.getCargo());
            System.out.println("----------------------------------------------------------");
        }
    }
}


















            /*for (Funcionario item : listaFuncionariosTemp){ // esse é um for mais complexo (for each), daria pra fazer com for simples tmb.
                System.out.println("----------------------------------------------------------");
                System.out.println("Nome funcionario: " + item.getNomePessoa());
                System.out.println("Nome CPF: " + item.getCpfPessoa());
                System.out.println("Nome cargo: " + item.getCargo());
                System.out.println("----------------------------------------------------------");
            }*/
        





        
 