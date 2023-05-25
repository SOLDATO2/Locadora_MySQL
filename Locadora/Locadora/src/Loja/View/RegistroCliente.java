package Loja.View;

import java.util.List;
import java.util.Scanner;

import Loja.Modelos.Aluguel;
import Loja.Modelos.Cliente;
import Loja.Modelos.ControleDeAluguel;
import Loja.Modelos.EstoqueLoja;
import Loja.Modelos.Filme;

public class RegistroCliente {

    static Scanner scannerInteiro = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void registroClienteFunc(EstoqueLoja CDs, EstoqueLoja VHS, int escolha, ControleDeAluguel cadastroClientes){

        

        if(Menu.listasEstaoVazias(CDs, VHS)== true){ // verifica se existe estoque para registrar clientes
            System.out.println("NÃO É POSSIVEL REGISTRAR CLIENTES POIS NÃO EXISTE FILMES EM ESTOQUE");
        }else{



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
                tipo = "CDs";
                if(Menu.listasEstaoVaziasUnica(CDs) == true){//fazer mais um if se a quantidade em estoque estiver zerada.
                    System.out.println("Não é possivel alugar CDs pois o estoque está vazio.");
                }else{
                    System.out.println("ESCOLHA UM GENERO:");
                    if(!(CDs.getListaDeTerror().isEmpty())){ // mostra as categorias que não estão vazias
                        System.out.println("[1] TERROR");
                    }
                    if(!(CDs.getListaDeAcao().isEmpty())){
                        System.out.println("[2] ACAO");
                    }
                    if(!(CDs.getListaDeDrama().isEmpty())){
                        System.out.println("[3] DRAMA");
                    }
                    if(!(CDs.getListaDeComedia().isEmpty())){
                        System.out.println("[4] COMEDIA");
                    }

                    escolha = scannerInteiro.nextInt();
                    int linha = 0;
                    
                    //Terror
                    if(escolha == 1){
                        genero = "Terror";
                        List<Filme> filmesTerror = CDs.getListaDeTerror();
                        for(linha = 0; linha < filmesTerror.size(); linha++){
                            if(filmesTerror.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + CDs.getListaDeTerror().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ CDs.getListaDeTerror().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                        
                        
                        if(filmesTerror.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= CDs.getListaDeTerror().get(escolha).getQnt()) {
                        
                            CDs.getListaDeTerror().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, CDs.getListaDeTerror().get(escolha).getNome(), quantidadeFilme, tipo, genero, CDs.getListaDeTerror().get(escolha).getCodigoProduto()); // codigo de produto armazena o codigo do produto para identificar onde esta o estoque do filme para futuras exclusoes
                                  
                                    
                            aluguel.adicionarFilmes(filmesTerror);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");
                        }else if (quantidadeFilme > CDs.getListaDeTerror().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");

                        }
                        
                       }else {
                           System.out.println("OPCAO INVALIDA!");
                       }
                    
                     //Acao
                    }else if(escolha == 2){
                        genero = "Acao";
                        List<Filme> filmesAcao = CDs.getListaDeAcao();
                        for(linha = 0; linha < filmesAcao.size(); linha++){
                            if(filmesAcao.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + CDs.getListaDeAcao().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ CDs.getListaDeAcao().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();

                        if(filmesAcao.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= CDs.getListaDeAcao().get(escolha).getQnt()) {
                        
                            CDs.getListaDeAcao().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, CDs.getListaDeAcao().get(escolha).getNome(), quantidadeFilme, tipo, genero, CDs.getListaDeAcao().get(escolha).getCodigoProduto());
                                    
                            aluguel.adicionarFilmes(filmesAcao);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > CDs.getListaDeAcao().get(escolha).getQnt()){
                            
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
                        List<Filme> filmesDrama = CDs.getListaDeDrama();
                        for(linha = 0; linha < filmesDrama.size(); linha++){
                            if(filmesDrama.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + CDs.getListaDeDrama().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ CDs.getListaDeDrama().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                        
                        
                        if(filmesDrama.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= CDs.getListaDeDrama().get(escolha).getQnt()) {
                        
                            CDs.getListaDeDrama().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, CDs.getListaDeDrama().get(escolha).getNome(), quantidadeFilme, tipo, genero, CDs.getListaDeDrama().get(escolha).getCodigoProduto());
                                    
                                    //Terminar primeiro para o genero terror e depois copiar para os outros 
                                  
                                    
                            aluguel.adicionarFilmes(filmesDrama);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > CDs.getListaDeDrama().get(escolha).getQnt()){
                            
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
                        List<Filme> filmesComedia = CDs.getListaDeComedia();
                        for(linha = 0; linha < filmesComedia.size(); linha++){
                            if(filmesComedia.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + CDs.getListaDeComedia().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ CDs.getListaDeComedia().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                
                        
                        if(filmesComedia.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= CDs.getListaDeComedia().get(escolha).getQnt()) {
                        
                            CDs.getListaDeComedia().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, CDs.getListaDeComedia().get(escolha).getNome(), quantidadeFilme, tipo, genero, CDs.getListaDeComedia().get(escolha).getCodigoProduto());
                            
                            aluguel.adicionarFilmes(filmesComedia);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > CDs.getListaDeComedia().get(escolha).getQnt()){
                            
                                    System.out.println("NAO FOI POSSIVEL FAZER O ALUGUEL!");
                                    System.out.println("QUANTIDADE EM ESTOQUE MENOR DO QUE A DESEJADA");
                        }
                        
                       }else {
                           
                           System.out.println("OPCAO INVALIDA!");
                           //System.out.println("SEM ESTOQUE PARA O FILME: " + CDs.getListaDeTerror().get(escolha).getNome());
                           
                       }
                    
                    }
                
                }

                
                //Aluguel de VHS
            }else if(escolha == 2){
                tipo = "VHS";
                if(Menu.listasEstaoVaziasUnica(VHS) == true){//fazer mais um if se a quantidade em estoque estiver zerada.
                    System.out.println("Não é possivel alugar CDs pois o estoque está vazio.");
                }else{
                    System.out.println("ESCOLHA UM GENERO:");
                    if(!(VHS.getListaDeTerror().isEmpty())){ // mostra as categorias que não estão vazias
                        System.out.println("[1] TERROR");
                    }
                    if(!(VHS.getListaDeAcao().isEmpty())){
                        System.out.println("[2] ACAO");
                    }
                    if(!(VHS.getListaDeDrama().isEmpty())){
                        System.out.println("[3] DRAMA");
                    }
                    if(!(VHS.getListaDeComedia().isEmpty())){
                        System.out.println("[4] COMEDIA");
                    }

                    escolha = scannerInteiro.nextInt();
                    int linha = 0;
                    
                    //Terror
                    if(escolha == 1){
                        genero = "Terror";
                        List<Filme> filmesTerror = VHS.getListaDeTerror();
                        for(linha = 0; linha < filmesTerror.size(); linha++){
                            if(filmesTerror.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + VHS.getListaDeTerror().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ VHS.getListaDeTerror().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(filmesTerror.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= VHS.getListaDeTerror().get(escolha).getQnt()) {
                        
                            VHS.getListaDeTerror().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, VHS.getListaDeTerror().get(escolha).getNome(), quantidadeFilme, tipo, genero, VHS.getListaDeTerror().get(escolha).getCodigoProduto());

                            aluguel.adicionarFilmes(filmesTerror);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > VHS.getListaDeTerror().get(escolha).getQnt()){
                            
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
                        List<Filme> filmesAcao = VHS.getListaDeAcao();
                        for(linha = 0; linha < filmesAcao.size(); linha++){
                            if(filmesAcao.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + VHS.getListaDeAcao().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ VHS.getListaDeAcao().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                     
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                
                        
                        if(filmesAcao.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= VHS.getListaDeAcao().get(escolha).getQnt()) {
                        
                            VHS.getListaDeAcao().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, VHS.getListaDeAcao().get(escolha).getNome(), quantidadeFilme, tipo, genero, VHS.getListaDeTerror().get(escolha).getCodigoProduto());
                                  
                                    
                            aluguel.adicionarFilmes(filmesAcao);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");
                        }else if (quantidadeFilme > VHS.getListaDeAcao().get(escolha).getQnt()){
                            
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
                        List<Filme> filmesDrama = VHS.getListaDeDrama();
                        for(linha = 0; linha < filmesDrama.size(); linha++){
                            if(filmesDrama.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + VHS.getListaDeDrama().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ VHS.getListaDeDrama().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }
                        
                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(filmesDrama.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= VHS.getListaDeDrama().get(escolha).getQnt()) {
                        
                            VHS.getListaDeDrama().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, VHS.getListaDeDrama().get(escolha).getNome(), quantidadeFilme, tipo, genero, VHS.getListaDeDrama().get(escolha).getCodigoProduto());
                                   
                            aluguel.adicionarFilmes(filmesDrama);
                            cadastroClientes.adicionar(aluguel);

                            System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > VHS.getListaDeDrama().get(escolha).getQnt()){
                            
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
                        List<Filme> filmesComedia = VHS.getListaDeComedia();
                        for(linha = 0; linha < filmesComedia.size(); linha++){
                            if(filmesComedia.get(linha).getQnt() > 0){
                                System.out.println("["+linha+"]"+":");
                                System.out.println("NOME: " + VHS.getListaDeComedia().get(linha).getNome());
                                System.out.println("QUANTIDADE: "+ VHS.getListaDeComedia().get(linha).getQnt());
                            }else {
                                System.out.println("DIGITE 0 PARA SAIR: ");
                            }
                        }

                        //Escolhe o filme da lista
                        System.out.println("ESCOLHA UMA OPÇÃO (0, 1, 2, etc...):");
                        escolha = scannerInteiro.nextInt();
                    
                        
                        if(filmesComedia.get(escolha).getQnt() > 0){

                        System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                        int quantidadeFilme = scannerInteiro.nextInt();
                        
                        if (quantidadeFilme <= VHS.getListaDeComedia().get(escolha).getQnt()) {
                        
                            VHS.getListaDeComedia().get(escolha).setQnt(quantidadeFilme);//Remove a quantidade pedida do estoque
                                    
                            Cliente cliente = new Cliente(nomeCliente, cpfCliente, numeroCelular);
                            Aluguel aluguel = new Aluguel(cliente, VHS.getListaDeComedia().get(escolha).getNome(), quantidadeFilme, tipo, genero, VHS.getListaDeComedia().get(escolha).getCodigoProduto());
                                           
                            aluguel.adicionarFilmes(filmesComedia);
                            cadastroClientes.adicionar(aluguel);

                                    System.out.println("ALUGUEL FEITO COM SUCESSO!");//mudar isso aqui
                        }else if (quantidadeFilme > VHS.getListaDeComedia().get(escolha).getQnt()){
                            
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
}
