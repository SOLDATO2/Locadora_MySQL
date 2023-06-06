package Loja.DAO;

import Loja.Modelos.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroEstoqueDAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    //Constructor
    public RegistroEstoqueDAO(){
        emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        em = emf.createEntityManager();
    }

    public  void salvarFilme(Filme filme){
        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
