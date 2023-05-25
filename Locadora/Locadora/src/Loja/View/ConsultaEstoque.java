package Loja.View;

import java.util.Scanner;

import Loja.Modelos.EstoqueLoja;

public class ConsultaEstoque {
    static Scanner scannerInteiro = new Scanner(System.in);
    public static void consultaAluguelFunc(int escolha, EstoqueLoja Estoque, EstoqueLoja VHS){
                

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
                            if(Estoque.getListaFilmes().get(x).getGenero() == "Terror"){
                                Menu.consultaNomeEQnt(Estoque);
                            }
                        }
                        // Genero Acao
                    }else if(escolha == 2){
                        if(CDs.getListaDeAcao().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntAcao(CDs);
                        }
                        // Genero Drama
                    }else if(escolha == 3){
                        if(CDs.getListaDeDrama().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntDrama(CDs);
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        if(CDs.getListaDeComedia().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntComedia(CDs);
                        }
                    }
                    // Consultar VHS 
                }else if(escolha == 2){
                    Menu.printGeneros();
                    escolha = scannerInteiro.nextInt();
                    if(escolha == 1){
                        if(VHS.getListaDeTerror().isEmpty()) {
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntTerror(VHS);
                        }
                        // Genero Acao
                    }else if(escolha == 2){
                        if(VHS.getListaDeAcao().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntAcao(VHS);
                        }
                        // Genero Drama
                    }else if(escolha == 3){
                        if(VHS.getListaDeDrama().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntDrama(VHS);
                        }
                        // Genero Comedia
                    }else if(escolha == 4){
                        if(VHS.getListaDeComedia().isEmpty()){
                            System.out.println("Não existe nenhum filme nesta categoria");
                        }else{
                            Menu.consultaNomeEQntComedia(VHS);
                        }
                    }
                }
        
    }
}
