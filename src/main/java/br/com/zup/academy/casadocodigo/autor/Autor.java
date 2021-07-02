package br.com.zup.academy.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull
    @NotEmpty
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
