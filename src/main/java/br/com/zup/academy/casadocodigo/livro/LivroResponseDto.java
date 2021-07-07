package br.com.zup.academy.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroResponseDto {

    public Integer id;
    public String titulo;

    public LivroResponseDto(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<LivroResponseDto> toDtoList(List<Livro> listaLivros) {
        List<LivroResponseDto> listaLivrosResponse = new ArrayList<>();
        for(Livro livro: listaLivros){
            listaLivrosResponse.add(new LivroResponseDto(livro));
        }
        return listaLivrosResponse;
    }
}
