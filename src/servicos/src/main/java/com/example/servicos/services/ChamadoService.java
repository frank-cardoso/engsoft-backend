package com.example.servicos.services;

import com.example.servicos.domain.Chamado;
import com.example.servicos.domain.Cliente;
import com.example.servicos.domain.Tecnico;
import com.example.servicos.dto.ChamadoDTO;
import com.example.servicos.repositories.ChamadoRepository;
import com.example.servicos.mappers.ChamadoMapper;
import com.example.servicos.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ChamadoMapper mapper;

    @Transactional(readOnly = true)
    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Chamado> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Chamado> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Chamado create(@Valid ChamadoDTO objDTO) {
        return repository.save(fromDTO(objDTO));
    }

    @Transactional
    public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
        objDTO.setId(id);
        findById(id);
        return repository.save(fromDTO(objDTO));
    }

    private Chamado fromDTO(ChamadoDTO objDTO) {
        Chamado newObj = mapper.toEntity(objDTO);
        newObj.setId(objDTO.getId());

        Tecnico tec = tecnicoService.findById(objDTO.getTecnico());
        Cliente cli = clienteService.findById(objDTO.getCliente());

        newObj.setTecnico(tec);
        newObj.setCliente(cli);

        if (newObj.getStatus().getCodigo().equals(2)) {
            newObj.setDataFechamento(LocalDate.now());
        }

        return newObj;
    }
}