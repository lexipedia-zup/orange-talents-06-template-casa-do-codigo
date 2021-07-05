package br.com.zup.academy.casadocodigo.autor;

import javax.validation.constraints.*;

public class AutorRequestDto {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @DuplicatedEmail(unique = true)
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
