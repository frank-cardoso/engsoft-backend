package com.example.servicos.resources;

import com.example.servicos.domain.Tecnico;
import com.example.servicos.dto.TecnicoDTO;
import com.example.servicos.services.TecnicoService;
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
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Tecnico> obj = service.findById(id);

        if (obj.isPresent()) {
            return ResponseEntity.ok().body(new TecnicoDTO(obj.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> list = service.findAll();
        List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO) {
        Tecnico newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO) {
        Optional<Tecnico> optionalTecnico = service.findById(id);

        if (optionalTecnico.isPresent()) {
            Tecnico oldObj = optionalTecnico.get();
            oldObj.setNome(objDTO.getNome());
            oldObj.setCpf(objDTO.getCpf());
            oldObj.setEmail(objDTO.getEmail());
            oldObj.setSenha(objDTO.getSenha());

            Tecnico updatedObj = service.update(oldObj);
            return ResponseEntity.ok().body(new TecnicoDTO(updatedObj));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}