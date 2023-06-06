package Loja.Modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa{

    
    String numeroCeluar;

    public Cliente(){

    }

    public Cliente(String nomePessoa, String cpfPessoa, String numeroCelular) {
        super(nomePessoa, cpfPessoa);
        this.numeroCeluar = numeroCelular;
    }

    public String getNumeroCeluar() {
        return numeroCeluar;
    }

    public void setNumeroCeluar(String numeroCeluar) {
        this.numeroCeluar = numeroCeluar;
    }

    
    
}
