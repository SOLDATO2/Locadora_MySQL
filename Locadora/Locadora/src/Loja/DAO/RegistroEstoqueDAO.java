package Loja.DAO;

import Loja.Modelos.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroEstoqueDAO {
    


    //Constructor
    public RegistroEstoqueDAO(Filme filme){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
