package Loja.DAO;

import java.util.List;

import Loja.Modelos.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConsultaEstoqueDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
    static EntityManager em = emf.createEntityManager();

    private List<Filme> filmes;

    //Constructor
    public ConsultaEstoqueDAO(String genero, String tipo){

        filmes = listar(genero, tipo);
    }

    
    // getter

    public List<Filme> getFilmes() {
        return filmes;
    }


    // metodo 
    private List<Filme> listar(String genero, String tipo){
        if(tipo == "CD"){

            List<Filme> filmes = em.createQuery("from Filme where tipo = 'CD' and genero = '"+genero+"'", Filme.class).getResultList();

            //TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.empNumber = :number" , Employee.class);
            //  String empNumber = "A123";
            //  Employee employee = query.setParameter("number", empNumber).getSingleResult();

            // TypedQuery<Filme> query = em.createQuery("from Filme f where f.tipo = :tipo and f.genero = :genero", Filme.class);
            // query.setParameter("tipo", "CD");
            // query.setParameter("genero", genero);
            // List<Filme> filmes  = query.getResultList();

            
            return filmes;
        }else if(tipo == "VHS"){

            TypedQuery<Filme> query = em.createQuery("from Filme where tipo = :tipo and genero = :genero", Filme.class);
            query.setParameter("tipo", "VHS");
            query.setParameter("genero", genero);
            List<Filme> filmes  = query.getResultList();
            return filmes;

            //List<Filme> filmes = em.createQuery("from Filme where tipo = 'VHS' and genero = '"+genero+"'", Filme.class).getResultList();
            //return filmes;
        }else{
            return null; 
        }
        
    }


    public Filme buscarPorID(int id){
        Filme filme = em.find(Filme.class, id);
        return filme;
    }

    public long atualizar(Filme filme){
        em.getTransaction().begin();
        em.merge(filme);
        em.getTransaction().commit();
        return filme.getId();
    }


    
}
