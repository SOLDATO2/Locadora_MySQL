package Loja.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nome;
    private int quantidade;
    private int codigoProduto;
    private String genero;
    private String tipo;
    
    
    public Filme(){
        
    }


    //constructor

    public Filme(String nomeQualquer, int quantidadeQualquer, int codigoProdutoQualquer, String genero, String tipo) {
        this.nome = nomeQualquer;
        this.quantidade = quantidadeQualquer;
        this.codigoProduto = codigoProdutoQualquer;
        this.genero = genero;
        this.tipo = tipo;
    }


    //getter
    public String getNome() {
        return nome;
    }

    

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getQnt(){
        return quantidade;
    }
    
    public int getCodigoProduto(){
        return codigoProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }

	public void setQnt(int qtdPedido) {
		this.quantidade = quantidade-qtdPedido;
	}

    public void setQntEstoque(int quantidade){
        this.quantidade = quantidade;

    }


    


}


