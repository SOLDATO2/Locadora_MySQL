package Loja.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa{

    

    
    private String cargo;

    public Funcionario(){

    }

    
    //Constructor
    public Funcionario(String nomePessoa, String cpfPessoa, String cargoFuncionario) {
        super(nomePessoa, cpfPessoa);
        this.cargo = cargoFuncionario;
    }

    //Getters
    public String getCargo() {
        return cargo;
    }






    
}
