package Loja.View;
import java.util.Scanner;


import Loja.Modelos.*;

public class Menu {
    static public void menuLoja(){
        EstoqueLoja Estoque = new EstoqueLoja();

        ControleDeAluguel cadastroClientes = new ControleDeAluguel();
     

        int quantidadeDevolucao = 0; // variavel que sera usada para devolver qnt alugada para o estoque 
        int escolha, codigoProduto = 100; // escolha menu e codigo que sera distribuido para cada produto 
        
        Scanner scannerInteiro = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        while(true){

            System.out.println("SISTEMA DE LOCADORA CD/VHS\n----------------------------------------------");
            System.out.println("ESCOLHA UMA OPÇÃO:");
            System.out.println("[1] REGISTRAR UM CD/VHS");
            System.out.println("[2] CONSULTAR ESTOQUE");
            System.out.println("[3] REGISTRAR FUNCIONARIOS");
            System.out.println("[4] CONSULTAR FUNCIONARIOS");
            System.out.println("[5] REGISTRAR UM ALUGUEL");
            System.out.println("[6] CONSULTAR ALUGUEIS");
            System.out.println("[7] REMOVER ALUGUEL");
            System.out.println("[0] SAIR");
            escolha = scannerInteiro.nextInt();
            // CDs
            if(escolha == 1){

                System.out.println("DESEJA REGISTRAR UM CD OU VHS?");
                System.out.println("[1] CD");
                System.out.println("[2] VHS");
                escolha = scannerInteiro.nextInt();
                if(escolha == 1){
                    

                    RegistroEstoque.registroEstoque(escolha, codigoProduto, "CD");
                    codigoProduto++;

                    //VHS
                }else if(escolha == 2){

                    RegistroEstoque.registroEstoque(escolha, codigoProduto, "VHS");
                    codigoProduto++;

                }
            }else if(escolha == 2){// consultar estoque
                ConsultaEstoque.consultaEstoqueFunc(escolha, Estoque);
            }else if(escolha == 3){

                RegistroFuncionario.registroFuncionarioFunc();

            }else if(escolha == 4){
                
                ConsultaFuncionario.consultaFuncionarioFunc();

            }else if(escolha == 5){ // REGISTRO DE CLIENTE ( EFETUAR ALUGUEL)
                

                RegistroCliente.registroClienteFunc(Estoque, escolha, cadastroClientes);


                     
            }else if(escolha == 6){// CONSULTA DE ALUGUEIS
                
                ConsultaAluguel.consultaAluguelFunc();

            }else if(escolha == 7){ // Apagar Clientes

                DevolucaoAluguel.DevolucaoAluguelFunc(cadastroClientes, escolha, Estoque, quantidadeDevolucao);
                
            }else if(escolha == 0){ // Terminar Programa
                scannerInteiro.close();
                scannerString.close();
                break;
            }else{
                System.out.println("Escolha Invalida.");
            
            }
        }
    }

    // Funcoes

    public static void printGeneros(){
        System.out.println("QUAL GENERO?");
        System.out.println("[1] TERROR");
        System.out.println("[2] ACAO");
        System.out.println("[3] DRAMA");
        System.out.println("[4] COMEDIA");
    }

   


    
}