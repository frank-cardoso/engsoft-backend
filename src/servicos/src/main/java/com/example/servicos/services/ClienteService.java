package com.example.servicos.services;

import com.example.servicos.domain.Cliente;
import com.example.servicos.domain.Tecnico;
import com.example.servicos.dto.ClienteDTO;
import com.example.servicos.mappers.ClienteMapper;
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
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteMapper mapper;

    @Transactional(readOnly = true)
    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " + id));
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional(readOnly = true)
    public Page<Cliente> findByNome(String nome, Pageable pageable) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Transactional
    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Cliente newObj = mapper.toEntity(objDTO);
        return clienteRepository.save(newObj);
    }

    @Transactional
    public Cliente update(Integer id, ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        validaPorCpfEEmail(objDTO);
        mapper.updateEntityFromDTO(objDTO, oldObj);
        return clienteRepository.save(oldObj);
    }

    @Transactional
    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getChamados().size() > 0) {
            throw new RuntimeException("Cliente possui chamados e não pode ser deletado!");
        }
        clienteRepository.deleteById(id);
    }

    private void validaPorCpfEEmail(ClienteDTO objDTO) {
        Optional<Cliente> clientePorCpf = clienteRepository.findByCpf(objDTO.getCpf());
        if (clientePorCpf.isPresent() && !clientePorCpf.get().getId().equals(objDTO.getId())) {
            throw new RuntimeException("CPF já cadastrado no sistema!");
        }

        Optional<Tecnico> tecnicoPorCpf = tecnicoRepository.findByCpf(objDTO.getCpf());
        if (tecnicoPorCpf.isPresent()) {
            throw new RuntimeException("CPF já cadastrado no sistema para um Técnico!");
        }

        Optional<Cliente> clientePorEmail = clienteRepository.findByEmail(objDTO.getEmail());
        if (clientePorEmail.isPresent() && !clientePorEmail.get().getId().equals(objDTO.getId())) {
            throw new RuntimeException("E-mail já cadastrado no sistema!");
        }

        Optional<Tecnico> tecnicoPorEmail = tecnicoRepository.findByEmail(objDTO.getEmail());
        if (tecnicoPorEmail.isPresent()) {
            throw new RuntimeException("E-mail já cadastrado no sistema para um Técnico!");
        }
    }
}