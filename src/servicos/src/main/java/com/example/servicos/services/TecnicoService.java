package com.example.servicos.services;

import com.example.servicos.domain.Tecnico;
import com.example.servicos.domain.enums.Perfil; // Verifique se este import existe
import com.example.servicos.dto.TecnicoDTO;
import com.example.servicos.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Optional<Tecnico> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        Tecnico newObj = new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getEmail(), objDTO.getSenha());

        if (objDTO.getPerfis() != null) {
            objDTO.getPerfis().forEach(codigo -> newObj.addPerfil(Perfil.toEnum(codigo)));
        }

        return repository.save(newObj);
    }

    public Tecnico update(Tecnico obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}