package Loja.Modelos;

public class Cliente extends Pessoa{



    String numeroCeluar;

    public Cliente(String nomePessoa, String cpfPessoa, String numeroCelular) {
        super(nomePessoa, cpfPessoa);
        this.numeroCeluar = numeroCelular;
    }


    public String getNumeroCeluar() {
        return numeroCeluar;
    }

    
    
    
    
    
}
