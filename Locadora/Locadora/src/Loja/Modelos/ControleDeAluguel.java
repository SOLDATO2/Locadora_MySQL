package Loja.Modelos;

import java.util.*;

public class ControleDeAluguel {

    private List<Aluguel> alugueis = new ArrayList<>();
    
    public void adicionar(Aluguel aluguelTemp){
        this.alugueis.add(aluguelTemp);
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    
}
