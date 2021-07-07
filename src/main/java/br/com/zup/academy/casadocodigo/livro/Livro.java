package br.com.zup.academy.casadocodigo.livro;

import br.com.zup.academy.casadocodigo.autor.Autor;
import br.com.zup.academy.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Column(length = 10000)
    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro(){
    }

    public Livro(String titulo,
                 String resumo,
                 String sumario,
                 Double preco,
                 Integer numeroDePaginas,
                 String isbn,
                 LocalDate dataPublicacao,
                 Categoria categoria,
                 Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
