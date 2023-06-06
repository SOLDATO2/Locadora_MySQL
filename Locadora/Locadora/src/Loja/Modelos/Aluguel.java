package Loja.Modelos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alugueis")
public class Aluguel{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private LocalDate dataLocacao = LocalDate.now();
    private LocalDate dataDevolucao = dataLocacao.plusDays(7);;
    private String dataFormatada = formatter.format(dataLocacao);
    private String dataDevolucaoFormatada = formatter.format(dataDevolucao);

    String nomeFilme, tipo, genero;
    int quantidadeAlugado, idFilmeBD;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente ClienteLocador;

    @OneToMany
    private List<Filme> filmesLocados = new ArrayList<>(); // ainda nao esta sendo usado. 4/27/23

    public Aluguel(){

    }

    public Aluguel(Cliente clienteLocadorEntrada, String nomeFilmeTemp, int quantidadeAlugadoTemp, String tipoTemp, String generoTemp, int idFilmeBDTemp){
        this.ClienteLocador = clienteLocadorEntrada;
        this.nomeFilme = nomeFilmeTemp;
        this.quantidadeAlugado = quantidadeAlugadoTemp;
        this.tipo = tipoTemp;
        this.genero = generoTemp;
        this.idFilmeBD = idFilmeBDTemp;
    }

    //adiciona unico filme
    public void adicionarFilme(Filme filme){
        this.filmesLocados.add(filme);
    }
    //adiciona varios filmes de uma vez
    public void adicionarFilmes(List<Filme> filmes){
        this.filmesLocados.addAll(filmes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public String getDataDevolucaoFormatada() {
        return dataDevolucaoFormatada;
    }

    public void setDataDevolucaoFormatada(String dataDevolucaoFormatada) {
        this.dataDevolucaoFormatada = dataDevolucaoFormatada;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getQuantidadeAlugado() {
        return quantidadeAlugado;
    }

    public void setQuantidadeAlugado(int quantidadeAlugado) {
        this.quantidadeAlugado = quantidadeAlugado;
    }

    public int getIdFilmeBD() {
        return idFilmeBD;
    }

    public void setIdFilmeBD(int idFilmeBD) {
        this.idFilmeBD = idFilmeBD;
    }

    public Cliente getClienteLocador() {
        return ClienteLocador;
    }

    public void setClienteLocador(Cliente clienteLocador) {
        ClienteLocador = clienteLocador;
    }

    public List<Filme> getFilmesLocados() {
        return filmesLocados;
    }

    public void setFilmesLocados(List<Filme> filmesLocados) {
        this.filmesLocados = filmesLocados;
    }


    

   



    // getters 
    //(Sistema para adicionar mais de 1 filme, ainda nao esta sendo utilizado 4/27/23)
   

    



    
   

    
}
