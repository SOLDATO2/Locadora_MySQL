package Loja.Modelos;

public class Filme {




    private String nome;
    private int quantidade;
    private int codigoProduto;
    private String genero;
    private String tipo;
    



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


