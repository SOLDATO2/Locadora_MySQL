package Loja.View;


import java.util.Scanner;

import Loja.Modelos.EstoqueLoja;
import Loja.Modelos.Filme;
import Loja.DAO.ConsultaEstoqueDAO;

public class ConsultaEstoque {




    static Scanner scannerInteiro = new Scanner(System.in);
    public static void consultaEstoqueFunc(int escolha, EstoqueLoja estoque){
                

                System.out.println("QUAL ESTOQUE GOSTARIA DE CONSULTAR?");
                System.out.println("[1] CD");
                System.out.println("[2] VHS");
                escolha = scannerInteiro.nextInt();
                // Consultar CDs    
                if(escolha == 1){
                    Menu.printGeneros();
                    escolha = scannerInteiro.nextInt();
                    // Genero Terror
                    if(escolha == 1){
                        /*for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Terror") && (Estoque.getListaFilmes().get(x).getTipo() == "CD")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }*/
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Terror", "CD");
                        
                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }

                        // Genero Acao
                    }else if(escolha == 2){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Acao", "CD");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }

                        // Genero Drama
                    }else if(escolha == 3){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Drama", "CD");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Comedia", "CD");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                    }
                    // Consultar VHS 
                }else if(escolha == 2){
                    Menu.printGeneros();
                    escolha = scannerInteiro.nextInt();
                    if(escolha == 1){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Terror", "VHS");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                        // Genero Acao
                    }else if(escolha == 2){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Acao", "VHS");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                        // Genero Drama
                    }else if(escolha == 3){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Drama", "VHS");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO("Comedia", "VHS");

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                    }
                }
        
    }

   
}
