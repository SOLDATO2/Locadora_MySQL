package Loja.Modelos;

public class Pessoa {
    private String nomePessoa;
    private String cpfPessoa;

    // Constructor
    public Pessoa(String nomePessoa, String cpfPessoa) {
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
    }
    
    //getters
    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    

    
}
