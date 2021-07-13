package br.com.zup.academy.casadocodigo.livro;

import br.com.zup.academy.casadocodigo.autor.Autor;
import br.com.zup.academy.casadocodigo.categoria.Categoria;
import br.com.zup.academy.casadocodigo.validations.Unique;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequestDto {

    @NotBlank
    @Unique(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @Unique(fieldName = "isbn", domainClass = Livro.class)
    private String isbn;

    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Integer categoriaId;

    @NotNull
    private Integer autorId;

    public LivroRequestDto(String titulo,
                           String resumo,
                           String sumario,
                           Double preco,
                           Integer numeroDePaginas,
                           String isbn,
                           LocalDate dataPublicacao,
                           Integer categoriaId,
                           Integer autorId){
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(Categoria categoria, Autor autor){
        return new Livro(this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataPublicacao,
                categoria,
                autor);
    }
}
