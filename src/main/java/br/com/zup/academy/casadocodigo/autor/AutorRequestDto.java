package br.com.zup.academy.casadocodigo.autor;

import br.com.zup.academy.casadocodigo.validations.Unique;

import javax.validation.constraints.*;

public class AutorRequestDto {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Unique(fieldName = "email", domainClass = Autor.class)
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
