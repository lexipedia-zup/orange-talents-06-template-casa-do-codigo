package br.com.zup.academy.casadocodigo.livro;

import br.com.zup.academy.casadocodigo.autor.Autor;

public class PaginaDetalheLivro {
    private String titulo;
    private Double preco;
    private String resumo;
    private String sumario;
    private Autor autor;
    private Integer numeroDePaginas;
    private String isbn;

    public PaginaDetalheLivro(){

    }

    public PaginaDetalheLivro(Livro livro){
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.autor = livro.getAutor();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Autor getAutor() {
        return autor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }
}
