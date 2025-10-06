package com.example.servicos.resources;

import com.example.servicos.domain.Cliente;
import com.example.servicos.dto.ClienteDTO;
import com.example.servicos.services.ClienteService;
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
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Cliente> obj = service.findById(id);

        if (obj.isPresent()) {
            return ResponseEntity.ok().body(new ClienteDTO(obj.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {
        Cliente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
        Optional<Cliente> optionalCliente = service.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente oldObj = optionalCliente.get();
            oldObj.setNome(objDTO.getNome());
            oldObj.setCpf(objDTO.getCpf());
            oldObj.setEmail(objDTO.getEmail());
            oldObj.setSenha(objDTO.getSenha());

            Cliente updatedObj = service.update(oldObj);
            return ResponseEntity.ok().body(new ClienteDTO(updatedObj));
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