package Loja.Modelos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;


@Entity

public class EstoqueLoja {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*private List<Filme> listaDeTerror = new ArrayList<>();
    private List<Filme> listaDeAcao = new ArrayList<>();
    private List<Filme> listaDeDrama = new ArrayList<>();
    private List<Filme> listaDeComedia = new ArrayList<>();*/

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

    

    
    
    /*public void addTerror(Filme terror){
        //adiciona um futuro objeto cd terror que pode ser criado para lista dinamica de terror
        listaDeTerror.add(terror);
    }

    public void addAcao(Filme acao){
        listaDeAcao.add(acao);
    }

    public void addDrama(Filme drama){
        listaDeDrama.add(drama);
    }

    public void addComedia(Filme comedia){
        listaDeComedia.add(comedia);
    }


    //getters
    public List<Filme> getListaDeTerror() {
        return listaDeTerror;
    }


    public List<Filme> getListaDeAcao() {
        return listaDeAcao;
    }


    public List<Filme> getListaDeDrama() {
        return listaDeDrama;
    }


    public List<Filme> getListaDeComedia() {
        return listaDeComedia;
    }*/

    
    
    



}
