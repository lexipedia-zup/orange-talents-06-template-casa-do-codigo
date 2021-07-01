package br.com.zup.academy.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody AutorRequestDto autorRequestDto){

        Autor autor = new Autor(autorRequestDto);
        autorRepository.save(autor);
        return ResponseEntity.ok().build();

    }

}
