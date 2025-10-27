package com.example.servicos.services;

import com.example.servicos.domain.Cliente;
import com.example.servicos.domain.Tecnico;
import com.example.servicos.dto.TecnicoDTO;
import com.example.servicos.mappers.TecnicoMapper;
import com.example.servicos.repositories.ClienteRepository;
import com.example.servicos.repositories.TecnicoRepository;
import com.example.servicos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TecnicoMapper mapper;

    @Transactional(readOnly = true)
    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! Id: " + id));
    }

    @Transactional(readOnly = true)
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Tecnico> findAll(Pageable pageable) {
        return tecnicoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Tecnico> findByNome(String nome) {
        return tecnicoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional(readOnly = true)
    public Page<Tecnico> findByNome(String nome, Pageable pageable) {
        return tecnicoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Transactional
    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Tecnico newObj = mapper.toEntity(objDTO);
        return tecnicoRepository.save(newObj);
    }

    @Transactional
    public Tecnico update(Integer id, TecnicoDTO objDTO) {
        objDTO.setId(id);
        Tecnico oldObj = findById(id);
        validaPorCpfEEmail(objDTO);

        mapper.updateEntityFromDTO(objDTO, oldObj);

        return tecnicoRepository.save(oldObj);
    }

    @Transactional
    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if (obj.getChamados().size() > 0) {
            throw new RuntimeException("Técnico possui chamados e não pode ser deletado!");
        }
        tecnicoRepository.deleteById(id);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
        Optional<Tecnico> tecnicoPorCpf = tecnicoRepository.findByCpf(objDTO.getCpf());
        if (tecnicoPorCpf.isPresent() && !tecnicoPorCpf.get().getId().equals(objDTO.getId())) {
            throw new RuntimeException("CPF já cadastrado no sistema!");
        }

        Optional<Cliente> clientePorCpf = clienteRepository.findByCpf(objDTO.getCpf());
        if (clientePorCpf.isPresent()) {
            throw new RuntimeException("CPF já cadastrado no sistema para um Cliente!");
        }

        Optional<Tecnico> tecnicoPorEmail = tecnicoRepository.findByEmail(objDTO.getEmail());
        if (tecnicoPorEmail.isPresent() && !tecnicoPorEmail.get().getId().equals(objDTO.getId())) {
            throw new RuntimeException("E-mail já cadastrado no sistema!");
        }

        Optional<Cliente> clientePorEmail = clienteRepository.findByEmail(objDTO.getEmail());
        if (clientePorEmail.isPresent()) {
            throw new RuntimeException("E-mail já cadastrado no sistema para um Cliente!");
        }
    }
}