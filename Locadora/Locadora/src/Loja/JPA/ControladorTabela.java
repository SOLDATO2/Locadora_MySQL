package Loja.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class ControladorTabela {
	
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void ControladorTabelaFunc(){
        emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        em = emf.createEntityManager();
        
    }

    
    
    
    
    
    
}
