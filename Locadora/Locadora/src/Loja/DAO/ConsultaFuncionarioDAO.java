package Loja.DAO;

import java.util.List;


import Loja.Modelos.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConsultaFuncionarioDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
    static EntityManager em = emf.createEntityManager();

    private List<Funcionario> funcionarios;

    public ConsultaFuncionarioDAO(){
        funcionarios = listarFuncionario();
    }
    

    public List<Funcionario> getFuncionario(){
        return funcionarios;
    }

    private List<Funcionario> listarFuncionario(){


        List<Funcionario> funcionarios = em.createQuery("from Funcionario", Funcionario.class).getResultList();
        return funcionarios;

    }
}
