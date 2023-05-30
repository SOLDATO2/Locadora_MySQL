package Loja.Modelos;

import java.util.List;




import java.util.ArrayList;




//ESSA CLASSE PODE DEIXAR DE EXISTER AO TRANSITAR PARA O BD

public class EstoqueLoja {










    private List<Filme> listaFilmes = new ArrayList<>();

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public void addLista(Filme filme){
        listaFilmes.add(filme);
    }


    /*public void salvarFilmeBD(){
        emf = Persistence.createEntityManagerFactory("exemplo_MySQL");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist();
        em.getTransaction().commit();
    }*/

    

    
    
   

    
    
    



}
