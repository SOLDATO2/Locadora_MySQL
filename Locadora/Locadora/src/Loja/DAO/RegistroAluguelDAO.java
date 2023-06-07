package Loja.DAO;

import Loja.Modelos.Aluguel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroAluguelDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public RegistroAluguelDAO(){
        emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        em = emf.createEntityManager();
    }


    public void salvarAluguel(Aluguel aluguel){
        em.getTransaction().begin();
        em.persist(aluguel);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
