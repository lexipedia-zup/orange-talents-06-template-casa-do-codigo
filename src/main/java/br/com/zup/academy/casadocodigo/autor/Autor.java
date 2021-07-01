package br.com.zup.academy.casadocodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
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
    private String email;
    @NotNull
    @NotEmpty
    @Size(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime dataCriacaoAutor;

    public Autor() {

    }

    public Autor(AutorRequestDto autorRequestDto){
        this.nome = autorRequestDto.getNome();
        this.email = autorRequestDto.getEmail();
        this.descricao = autorRequestDto.getDescricao();
        this.dataCriacaoAutor = LocalDateTime.now();
    }

}
