package Loja.View;


import java.util.Scanner;

import Loja.DAO.ConsultaEstoqueDAO;
import Loja.DAO.RegistroAluguelDAO;
import Loja.DAO.RegistroClienteDAO;
import Loja.Modelos.Aluguel;
import Loja.Modelos.Cliente;
import Loja.Modelos.ControleDeAluguel;
import Loja.Modelos.EstoqueLoja;
import Loja.Modelos.Filme;

public class RegistroCliente {

    static Scanner scannerInteiro = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void registroClienteFunc(EstoqueLoja Estoque, int escolha, ControleDeAluguel cadastroClientes){

        
        // tem repeticao pra kct aqui, tem que reduzir isso 
        
        


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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                        
                        //Drama
                    }else if(escolha == 3){
                        genero = "Drama";
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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

                        //Comedia
                    }else if(escolha == 4){
                        genero = "Comedia";
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                    
                    }
                
                

                
                //Aluguel de VHS
            }else if(escolha == 2){
                if(escolha == 1){
                    tipo = "VHS";
                    System.out.println("ESCOLHA UM GENERO:");
                    System.out.println("[1] TERROR");
                    System.out.println("[2] ACAO");
                    System.out.println("[3] DRAMA");
                    System.out.println("[4] COMEDIA");
    
                    escolha = scannerInteiro.nextInt();
                    
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                        
                        //Drama
                       }else if(escolha == 3){
                        genero = "Drama";
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
                        //Comedia
                    }else if(escolha == 4){
                        genero = "Comedia";
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
                                RegistroClienteDAO registroCliente = new RegistroClienteDAO();
                                registroCliente.salvarCliente(cliente);

                                Aluguel aluguel = new Aluguel(cliente, consultaEstoque.buscarPorID(escolha).getNome(), quantidadeFilme, tipo, genero, consultaEstoque.buscarPorID(escolha).getId()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                RegistroAluguelDAO registroAluguel = new RegistroAluguelDAO();
                                registroAluguel.salvarAluguel(aluguel);
                                        
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
