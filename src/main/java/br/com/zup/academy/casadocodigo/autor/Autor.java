package br.com.zup.academy.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime dataCriacaoAutor;

    public Autor() {

    }

    public Autor(String nome, String email, String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacaoAutor = LocalDateTime.now();
    }

}
