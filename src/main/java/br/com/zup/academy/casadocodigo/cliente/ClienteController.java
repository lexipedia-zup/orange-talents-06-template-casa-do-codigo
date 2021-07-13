package br.com.zup.academy.casadocodigo.cliente;

import br.com.zup.academy.casadocodigo.estado.Estado;
import br.com.zup.academy.casadocodigo.estado.EstadoRepository;
import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteRequestDto dto){
        Optional<Estado> optionalEstado = estadoRepository.findById(dto.getIdEstado());
        Estado estado = null;
        if(optionalEstado.isPresent()){
            estado = optionalEstado.get();
        }
        Pais pais = paisRepository.findById(dto.getIdPais()).get();
        Cliente cliente = dto.toModel(estado, pais);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body("Id do cliente cadastrado:" + cliente.getId());
    }
}
