package Loja.View;

import Loja.DAO.ConsultaAluguelDAO;
import Loja.Modelos.Aluguel;


public class ConsultaAluguel {
    public static void consultaAluguelFunc(){
        
                //Data do aluguel e prazo de devolucao
                
                
                ConsultaAluguelDAO consultaAluguel = new ConsultaAluguelDAO();

                System.out.println("CONSULTA DE ALUGUEIS");
            for (Aluguel item  : consultaAluguel.getAlugueis()){ // esse é um for mais complexo (for each), daria pra fazer com for simples tmb.
                System.out.println("----------------------------------------------------------");
                System.out.println("Nome cliente: " + item.getClienteLocador().getNomePessoa());
                System.out.println("CPF: " + item.getClienteLocador().getCpfPessoa());
                System.out.println("Numero de Celular: "+ item.getClienteLocador().getNumeroCeluar());
                //Adicionar for para nome do filme e qntd
                System.out.println("Nome do filme alugado: " + item.getNomeFilme()+" qtd:" + item.getQuantidadeAlugado());
                System.out.println("Codigo do produto alugado: " + item.getIdFilmeBD());
                System.out.println("Data do aluguel: " + item.getDataFormatada());
                System.out.println("Data de devolucao: " + item.getDataDevolucaoFormatada());
                System.out.println("----------------------------------------------------------");
        
            }
    }
}
