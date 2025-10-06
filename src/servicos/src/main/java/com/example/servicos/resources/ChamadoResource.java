package com.example.servicos.resources;

import com.example.servicos.domain.Chamado;
import com.example.servicos.dto.ChamadoDTO;
import com.example.servicos.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Chamado> obj = service.findById(id);
        if(obj.isPresent()) {
            return ResponseEntity.ok().body(new ChamadoDTO(obj.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> list = service.findAll();
        List<ChamadoDTO> listDTO = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDTO) {
        Chamado newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ChamadoDTO objDTO) {
        Optional<Chamado> optionalUpdatedChamado = service.update(id, objDTO);

        if (optionalUpdatedChamado.isPresent()) {
            Chamado updatedObj = optionalUpdatedChamado.get();
            return ResponseEntity.ok().body(new ChamadoDTO(updatedObj));
        }

        return ResponseEntity.notFound().build();
    }
}