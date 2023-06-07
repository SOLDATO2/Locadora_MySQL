package Loja.DAO;

import java.util.List;

import Loja.Modelos.Aluguel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConsultaAluguelDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
    static EntityManager em = emf.createEntityManager();

    private List<Aluguel> alugueis;

    public ConsultaAluguelDAO(){

    
        alugueis = listar();
    }

    

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }


    private List<Aluguel> listar(){
        List<Aluguel> alugueis = em.createQuery("from Aluguel", Aluguel.class).getResultList();
        return alugueis;
    }

    
}
