package Loja.View;

import Loja.Modelos.Aluguel;
import Loja.Modelos.ControleDeAluguel;
import Loja.Modelos.EstoqueLoja;

public class ConsultaAluguel {
    public static void consultaAluguelFunc(EstoqueLoja Estoque, ControleDeAluguel cadastroClientes){
        if(Menu.listaEstaVazia(Estoque) == true){
            System.out.println("Não é possivel registrar um aluguel pois não existe nenhum filme em estoque.");
        }else if(cadastroClientes.getAlugueis().isEmpty()){
            System.out.println("Não é possivel consultar um aluguel pois não existe nenhum cliente registrado.");
        }else{
                //Data do aluguel e prazo de devolucao
                
                
                System.out.println("CONSULTA DE ALUGUEIS");
            for (Aluguel item  : cadastroClientes.getAlugueis()){ // esse é um for mais complexo (for each), daria pra fazer com for simples tmb.
                System.out.println("----------------------------------------------------------");
                System.out.println("Nome cliente: " + item.getCliente().getNomePessoa());
                System.out.println("CPF: " + item.getCliente().getCpfPessoa());
                System.out.println("Numero de Celular: "+ item.getCliente().getNumeroCeluar());
                //Adicionar for para nome do filme e qntd
                System.out.println("Nome do filme alugado: " + item.getNomeFilme()+" qtd:" + item.getQuantidadeAlugado());
                System.out.println("Codigo do produto alugado: " + item.getCodigoProdutoAluguel());
                System.out.println("Data do aluguel: " + item.getDataFormatada());
                System.out.println("Data de devolucao: " + item.getDataDevolucaoFormatada());
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}
