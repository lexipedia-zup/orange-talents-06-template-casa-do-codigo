package br.com.zup.academy.casadocodigo.estado;

import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.pais.PaisRepository;
import br.com.zup.academy.casadocodigo.validations.Unique;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequestDto dto){

        Optional<Pais> pais = paisRepository.findById(dto.getIdPais());

        Estado estado = dto.toModel(dto, pais.get());

        estadoRepository.save(estado);

        return ResponseEntity.ok().build();

    }

}
