package br.com.zup.academy.casadocodigo.estado;

import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.validations.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertence(Pais pais){
        return this.pais.equals(pais);
    }
}
