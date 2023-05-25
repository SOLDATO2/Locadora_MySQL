package Loja.Modelos;

public class Funcionario extends Pessoa{

    private String cargo;

    
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
