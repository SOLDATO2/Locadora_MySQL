package Loja.DAO;

import Loja.Modelos.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroEstoqueDAO {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
    static EntityManager em = emf.createEntityManager();

    public RegistroEstoqueDAO(Filme filme){
        
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
