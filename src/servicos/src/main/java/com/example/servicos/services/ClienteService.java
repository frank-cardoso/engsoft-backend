package com.example.servicos.services;

import com.example.servicos.domain.Cliente;
import com.example.servicos.dto.ClienteDTO;
import com.example.servicos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        Cliente newObj = new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getEmail(), objDTO.getSenha());
        return repository.save(newObj);
    }

    public Cliente update(Cliente obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}