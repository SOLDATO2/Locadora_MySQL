package Loja.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nomePessoa;
    private String cpfPessoa;


     public Pessoa(){

     }

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

    public long getId(){
        return id;
    }

    
}
