package Loja.DAO;

import Loja.Modelos.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroClienteDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public RegistroClienteDAO(){
        emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        em = emf.createEntityManager();
    }


    public void salvarCliente(Cliente cliente){
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
