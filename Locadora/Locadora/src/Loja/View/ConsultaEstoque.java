package Loja.View;

import java.util.Scanner;

import Loja.Modelos.EstoqueLoja;

public class ConsultaEstoque {
    static Scanner scannerInteiro = new Scanner(System.in);
    public static void consultaEstoqueFunc(int escolha, EstoqueLoja Estoque){
                

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
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Terror") && (Estoque.getListaFilmes().get(x).getTipo() == "CD")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Acao
                    }else if(escolha == 2){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Acao") && (Estoque.getListaFilmes().get(x).getTipo() == "CD")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Drama
                    }else if(escolha == 3){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Drama") && (Estoque.getListaFilmes().get(x).getTipo() == "CD")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Comedia") && (Estoque.getListaFilmes().get(x).getTipo() == "CD")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                    }
                    // Consultar VHS 
                }else if(escolha == 2){
                    Menu.printGeneros();
                    escolha = scannerInteiro.nextInt();
                    if(escolha == 1){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Terror") && (Estoque.getListaFilmes().get(x).getTipo() == "VHS")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Acao
                    }else if(escolha == 2){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Acao") && (Estoque.getListaFilmes().get(x).getTipo() == "VHS")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Drama
                    }else if(escolha == 3){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Drama") && (Estoque.getListaFilmes().get(x).getTipo() == "VHS")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        for(int x = 0; x < Estoque.getListaFilmes().size(); x++){
                            if((Estoque.getListaFilmes().get(x).getGenero() == "Comedia") && (Estoque.getListaFilmes().get(x).getTipo() == "VHS")){
                                Menu.consultaNomeEQnt(Estoque, x);
                            }
                        }
                    }
                }
        
    }
}
