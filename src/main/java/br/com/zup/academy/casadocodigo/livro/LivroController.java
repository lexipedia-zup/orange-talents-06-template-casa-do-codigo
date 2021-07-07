package br.com.zup.academy.casadocodigo.livro;

import br.com.zup.academy.casadocodigo.autor.Autor;
import br.com.zup.academy.casadocodigo.autor.AutorRepository;
import br.com.zup.academy.casadocodigo.categoria.Categoria;
import br.com.zup.academy.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody LivroRequestDto dto) {
        Optional<Autor> autorOptional = autorRepository.findById(dto.getAutorId());
        Autor autor = null;
        if (autorOptional.isPresent()) {
            autor = autorOptional.get();
        }

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(dto.getCategoriaId());
        Categoria categoria = null;
        if (categoriaOptional.isPresent()) {
            categoria = categoriaOptional.get();
        }

        Livro livro = dto.toModel(dto, categoria, autor);

        livroRepository.save(livro);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>> buscarLivros() {
        List<Livro> listaLivros = livroRepository.findAll();
        List<LivroResponseDto> listaLivrosResponse = LivroResponseDto.toDtoList(listaLivros);
        return ResponseEntity.ok().body(listaLivrosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaginaDetalheLivro> buscaPaginaDetalhe(@PathVariable Integer id) {
        PaginaDetalheLivro paginaDetalheLivro = new PaginaDetalheLivro(livroRepository.findById(id).get());
        return ResponseEntity.ok().body(paginaDetalheLivro);
    }

}
