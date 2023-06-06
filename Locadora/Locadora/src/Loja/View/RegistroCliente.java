package Loja.View;


import java.util.Scanner;

import Loja.DAO.ConsultaEstoqueDAO;
import Loja.Modelos.Aluguel;
import Loja.Modelos.Cliente;
import Loja.Modelos.ControleDeAluguel;
import Loja.Modelos.EstoqueLoja;
import Loja.Modelos.Filme;

public class RegistroCliente {

    static Scanner scannerInteiro = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void registroClienteFunc(EstoqueLoja Estoque, int escolha, ControleDeAluguel cadastroClientes){

        

        
        


            // Pede informações do cliente para registro
            String nomeCliente, cpfCliente, numeroCelular;
            System.out.println("QUAL É O NOME DO CLIENTE?");
            nomeCliente = scannerString.nextLine();
            System.out.println("DIGITE O CPF DO CLIENTE:");
            cpfCliente = scannerString.nextLine();
            System.out.println("QUAL É O NUMERO DE TELEFONE:");
            numeroCelular = scannerString.nextLine();

            
            int continuar=0;
            
            do {
            
            
            System.out.println("ESCOLHA UMA DAS OPCOES:");
            System.out.println("[1] CDs");
            System.out.println("[2] VHS");
            System.out.println("[3] FINALIZAR ALUGUEL");

            escolha = scannerInteiro.nextInt();
            
            String tipo;
            String genero;
            if(escolha == 1){
                tipo = "CD";
                    System.out.println("ESCOLHA UM GENERO:");
                    System.out.println("[1] TERROR");
                    System.out.println("[2] ACAO");
                    System.out.println("[3] DRAMA");
                    System.out.println("[4] COMEDIA");

                    escolha = scannerInteiro.nextInt();
                    int linha = 0;
                    
                    //Terror
                    if(escolha == 1){
                        genero = "Terror";
                        
                        ConsultaEstoqueDAO consultaEstoque = new ConsultaEstoqueDAO(genero, tipo);

                        for(Filme filme : consultaEstoque.getFilmes()){
                            System.out.println("----------------------------------------------------------");
                            System.out.println("ID: "+ filme.getId());
                            System.out.println("Nome do filme: " + filme.getNome());
                            System.out.println("Quantidade: " + filme.getQnt());
                            System.out.println("Codigo do produto: " + filme.getCodigoProduto());
                            System.out.println("----------------------------------------------------------");
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):"); // escolher id com base em consultaEstoque
                        escolha = scannerInteiro.nextInt();
                        
        
                        
                        if(consultaEstoque.buscarPorID(escolha).getQnt() > 0){

                            System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                            int quantidadeFilme = scannerInteiro.nextInt();
                            
                            if (quantidadeFilme <= consultaEstoque.buscarPorID(escolha).getQnt()) {
                            
                                Filme filmeTemp = consultaEstoque.buscarPorID(escolha);// criar update para modificar estoque
                            
                                filmeTemp.setQntEstoque(consultaEstoque.buscarPorID(escolha).getQnt() - quantidadeFilme);
                                consultaEstoque.atualizar(filmeTemp);        


                                Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                                //Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                    
                                        
                                //aluguel.adicionarFilmes(Estoque.getListaFilmes()); // adicionar aluguel na tabela aluguel
                                //cadastroClientes.adicionar(aluguel); // adicionar aluguel na tabela controle de aluguel

                                System.out.println("ALUGUEL FEITO COM SUCESSO!");
                            }else if (quantidadeFilme > consultaEstoque.buscarPorID(escolha).getQnt()){
                                
                                        System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                        System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");

                            }
                        
                       }else {
                           System.out.println("OPCAO INVALIDA!");
                       }
                    
                     //Acao
                    }else if(escolha == 2){
                        genero = "Acao";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();

                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());
                                    
                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");

                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                        
                        //Drama
                    }else if(escolha == 3){
                        genero = "Drama";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                        
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());
                                    
                                    //Terminar primeiro para o genero terror e depois copiar para os outros 
                                  
                                    
                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");

                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }

                        //Comedia
                    }else if(escolha == 4){
                        genero = "Comedia";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                        
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());
                                    
                                    //Terminar primeiro para o genero terror e depois copiar para os outros 
                                  
                                    
                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");

                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                    
                    }
                
                

                
                //Aluguel de VHS
            }else if(escolha == 2){
                tipo = "VHS";
                if(Menu.listaEstaVazia(Estoque) == true){//fazer mais um if se a quantidade em estoque estiver zerada.
                    System.out.println("Não é possivel alugar CDs pois o estoque está vazio.");
                }else{
                    System.out.println("ESCOLHA UM GENERO:");
                    System.out.println("[1] TERROR");
                    System.out.println("[2] ACAO");
                    System.out.println("[3] DRAMA");
                    System.out.println("[4] COMEDIA");

                    escolha = scannerInteiro.nextInt();
                    int linha = 0;
                    
                    //Terror
                    if(escolha == 1){
                        genero = "Terror";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());

                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");
                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                    
                     //Acao
                    }else if(escolha == 2){
                        genero = "Acao";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());

                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");
                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                        
                        //Drama
                       }else if(escolha == 3){
                        genero = "Drama";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());

                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");
                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                        //Comedia
                    }else if(escolha == 4){
                        genero = "Comedia";
                        for(linha = 0; linha < Estoque.getListaFilmes().size(); linha++){
                            if((Estoque.getListaFilmes().get(linha).getQnt() > 0) && (Estoque.getListaFilmes().get(linha).getGenero() == genero) && (Estoque.getListaFilmes().get(linha).getTipo() == tipo)){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + Estoque.getListaFilmes().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ Estoque.getListaFilmes().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(Estoque.getListaFilmes().get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= Estoque.getListaFilmes().get(escolha).getQnt()) {
                        
                            Estoque.getListaFilmes().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, Estoque.getListaFilmes().get(escolha).getNome(), quantidadeFilme, tipo, genero, Estoque.getListaFilmes().get(escolha).getCodigoProduto());

                            aluguel.adicionarFilmes(Estoque.getListaFilmes());
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > Estoque.getListaFilmes().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");
                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                    
                    //
                    
                }
                
              }
           }
          //ESSA PARTE TA MEIO SUSPEITA, DA PRA FAZER COM BOOL MAS EU NAO ESTOU ACOSTUMADO
            if(escolha==3) {
                continuar=1;
                System.out.println("REGISTRO DE ALUGUEL ENCERRADO\n");
            }
            
           }while(continuar!=1);//Loop para alugar mais filmes
        
    }




}
