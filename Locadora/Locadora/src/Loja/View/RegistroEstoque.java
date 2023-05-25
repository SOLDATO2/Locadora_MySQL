package Loja.View;
import Loja.Modelos.EstoqueLoja;
import Loja.Modelos.Filme;
import java.util.Scanner;

public class RegistroEstoque {
    

    // Este é um exemplo de sub menu que será implementado(apos terminar o trabalho) em Menu.java no lugar da primeira opção
    // essa classe vai gerar um objeto em menu.java, daria para fazer sem ser objeto, mas como exemplo eu achei melhor deixar como um objeto.
    // basta escrever RegistroEstoque registroEstoque = new RegistroEstoque(escolha, CDs, VHS); em menu e apagar o resto de codigo.
    // o programa ira indicar que o objeto não esta sendo usado

    private static String nome;
    private static int quantidade;
    

    static Scanner scannerInteiro = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    
    

    public static void registroEstoqueCD(int escolha, EstoqueLoja Estoque, int codigoProduto) {
                    System.out.println("QUAL GENERO?");
                    System.out.println("[1] TERROR");
                    System.out.println("[2] ACAO");
                    System.out.println("[3] DRAMA");
                    System.out.println("[4] COMEDIA");
                    escolha = scannerInteiro.nextInt();
                    if(escolha == 1){ // Adiciona Terror
                        
                        Estoque.addLista(registro(codigoProduto, Estoque, "Terror", "CD"));
                        System.out.println("ADICIONADO COM SUCESSO!");
                    }else if(escolha == 2){ // Adiciona Acao
                        
                        Estoque.addLista(registro(codigoProduto, Estoque, "Acao", "CD"));
                        System.out.println("ADICIONADO COM SUCESSO!");
                    }else if(escolha == 3){ // Adiciona Drama
                        
                        Estoque.addLista(registro(codigoProduto, Estoque, "Drama", "CD"));
                        System.out.println("ADICIONADO COM SUCESSO!");
                    }else if(escolha == 4){ // Adiciona Comedia
                
                        Estoque.addLista(registro(codigoProduto, Estoque, "Comedia", "CD"));
                        System.out.println("ADICIONADO COM SUCESSO!");
                    }
        
                }


    public static void registroEstoqueVHS(int escolha, EstoqueLoja Estoque, int codigoProduto) {
        System.out.println("QUAL GENERO?");
        System.out.println("[1] TERROR");
        System.out.println("[2] ACAO");
        System.out.println("[3] DRAMA");
        System.out.println("[4] COMEDIA");
        escolha = scannerInteiro.nextInt();
            if(escolha == 1){ // Adiciona Terror
                        
                Estoque.addLista(registro(codigoProduto, Estoque, "Terror", "VHS"));
                System.out.println("ADICIONADO COM SUCESSO!");
            }else if(escolha == 2){ // Adiciona Acao
                        
                Estoque.addLista(registro(codigoProduto, Estoque, "Acao", "VHS"));
                System.out.println("ADICIONADO COM SUCESSO!");
            }else if(escolha == 3){ // Adiciona Drama
                        
                Estoque.addLista(registro(codigoProduto, Estoque, "Drama", "VHS"));
                System.out.println("ADICIONADO COM SUCESSO!");
            }else if(escolha == 4){ // Adiciona Comedia
                
                Estoque.addLista(registro(codigoProduto, Estoque, "Comedia", "VHS"));
                System.out.println("ADICIONADO COM SUCESSO!");
            }
        
    }

    static Filme registro(int codigoProduto, EstoqueLoja tipoEstoque, String genero, String tipo){
        System.out.println("QUAL É O NOME DO FILME?");
        nome = scannerString.nextLine();
        System.out.println("QUAL É A QUANTIDADADE?");
        quantidade = scannerInteiro.nextInt();
        Filme filme = new Filme(nome, quantidade, codigoProduto, genero, tipo);
        return filme;

    }
}

    


