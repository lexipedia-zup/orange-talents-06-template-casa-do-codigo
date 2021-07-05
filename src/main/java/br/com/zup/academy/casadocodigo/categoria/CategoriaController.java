package br.com.zup.academy.casadocodigo.categoria;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid CategoriaRequestDto categoriaRequestDto){

        Categoria categoria = categoriaRequestDto.toModel(categoriaRequestDto);

        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();

    }
}
