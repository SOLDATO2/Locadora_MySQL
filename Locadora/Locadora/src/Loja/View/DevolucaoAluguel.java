package Loja.View;

import java.util.Scanner;

import Loja.Modelos.Aluguel;
import Loja.Modelos.ControleDeAluguel;
import Loja.Modelos.EstoqueLoja;

public class DevolucaoAluguel {
    
    static Scanner scannerInteiro = new Scanner(System.in);

    public static void DevolucaoAluguelFunc(ControleDeAluguel cadastroClientes, int escolha, EstoqueLoja CDs, EstoqueLoja VHS, int quantidadeDevolucao){
        
        if(cadastroClientes.getAlugueis().isEmpty()){
            System.out.println("NÃO É POSSIVEL EFETUAR DEVOLUÇÃO POIS NÃO EXISTE ALUGUEIS REGISTRADOS");
        }else{
            int contador = 0;
            System.out.println("LISTANDO CLIENTES:");
            for (Aluguel item : cadastroClientes.getAlugueis()){ // esse é um for mais complexo (for each), daria pra fazer com for simples tmb.
                System.out.println("----------------------------------------------------------");
                System.out.println("["+contador+"]");
                System.out.println("Nome cliente: " + item.getCliente().getNomePessoa());
                System.out.println("CPF: " + item.getCliente().getCpfPessoa());
                System.out.println("Numero de Celular: "+ item.getCliente().getNumeroCeluar());
                //Adicionar for para nome do filme e qntd
                System.out.println("Nome do filme alugado: " + item.getNomeFilme()+" qtd:" + item.getQuantidadeAlugado());
                System.out.println("Codigo do produto alugado: " + item.getCodigoProdutoAluguel());
                System.out.println("Data do aluguel: " + item.getDataFormatada());
                System.out.println("Data de devolucao: " + item.getDataDevolucaoFormatada());
                System.out.println("----------------------------------------------------------");
                contador++;
            }

            System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
            escolha = scannerInteiro.nextInt();
            //Falta devolver quantidade que cliente alugou para estoque (25/04/23)
            
            //CDs
            if(cadastroClientes.getAlugueis().get(escolha).getTipo() == "CDs"){
                if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Terror"){
                    for(int x = 0; x < CDs.getListaDeTerror().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == CDs.getListaDeTerror().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = CDs.getListaDeTerror().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            CDs.getListaDeTerror().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }

                    

                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Acao"){
                    for(int x = 0; x < CDs.getListaDeAcao().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == CDs.getListaDeAcao().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = CDs.getListaDeAcao().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            CDs.getListaDeAcao().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }

                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Drama"){
                    for(int x = 0; x < CDs.getListaDeDrama().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == CDs.getListaDeDrama().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = CDs.getListaDeDrama().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            CDs.getListaDeDrama().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }

                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Comedia"){
                    for(int x = 0; x < CDs.getListaDeComedia().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == CDs.getListaDeComedia().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = CDs.getListaDeComedia().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            CDs.getListaDeComedia().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }
                }//VHS
            }else if(cadastroClientes.getAlugueis().get(escolha).getTipo() == "VHS"){
                if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Terror"){
                    for(int x = 0; x < VHS.getListaDeTerror().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == VHS.getListaDeTerror().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = VHS.getListaDeTerror().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            VHS.getListaDeComedia().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }
                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Acao"){
                    for(int x = 0; x < VHS.getListaDeAcao().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == VHS.getListaDeAcao().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = VHS.getListaDeAcao().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            VHS.getListaDeAcao().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }
                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Drama"){
                    for(int x = 0; x < VHS.getListaDeDrama().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == VHS.getListaDeDrama().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = VHS.getListaDeDrama().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            VHS.getListaDeDrama().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }
                }else if(cadastroClientes.getAlugueis().get(escolha).getGenero() == "Comedia"){
                    for(int x = 0; x < VHS.getListaDeComedia().size(); x++){
                        if(cadastroClientes.getAlugueis().get(escolha).getCodigoProdutoAluguel() == VHS.getListaDeComedia().get(x).getCodigoProduto()){ // compara o codigo de produto que o cliente alugou com o codigo que tem em estoque
                            quantidadeDevolucao = 0;
                            quantidadeDevolucao = VHS.getListaDeComedia().get(x).getQnt();
                            quantidadeDevolucao += cadastroClientes.getAlugueis().get(escolha).getQuantidadeAlugado();


                            VHS.getListaDeComedia().get(x).setQntEstoque(quantidadeDevolucao);
                        }
                    }
                }
            }
            
            cadastroClientes.getAlugueis().remove(escolha);
            System.out.println("ALUGUEL APAGADO COM SUCESSO");
        }
    }
}
