package Loja.DAO;

import java.util.List;

import Loja.Modelos.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
            return filmes;
        }else if(tipo == "VHS"){
            List<Filme> filmes = em.createQuery("from Filme where tipo = 'VHS' and genero = '"+genero+"'", Filme.class).getResultList();
            return filmes;
        }else{
            return null; 
        }
        
    }
}
