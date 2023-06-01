package Loja.DAO;

import Loja.Modelos.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegistroFuncionarioDAO {

    public RegistroFuncionarioDAO(Funcionario funcionario){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
