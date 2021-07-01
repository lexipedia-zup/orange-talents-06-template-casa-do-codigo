package br.com.zup.academy.casadocodigo.autor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorRequestDto {

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

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
