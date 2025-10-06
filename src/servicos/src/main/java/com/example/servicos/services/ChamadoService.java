package com.example.servicos.services;

import com.example.servicos.domain.Chamado;
import com.example.servicos.domain.Cliente;
import com.example.servicos.domain.Tecnico;
import com.example.servicos.domain.enums.Prioridade;
import com.example.servicos.domain.enums.Status;
import com.example.servicos.dto.ChamadoDTO;
import com.example.servicos.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Chamado> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO objDTO) {
        Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico()).orElse(null);
        Cliente cliente = clienteService.findById(objDTO.getCliente()).orElse(null);

        Chamado newObj = new Chamado();
        if (objDTO.getStatus().equals(2)) {
            newObj.setDataFechamento(LocalDate.now());
        }

        newObj.setTecnico(tecnico);
        newObj.setCliente(cliente);
        newObj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
        newObj.setStatus(Status.toEnum(objDTO.getStatus()));
        newObj.setTitulo(objDTO.getTitulo());
        newObj.setObservacoes(objDTO.getObservacoes());
        return repository.save(newObj);
    }

    public Optional<Chamado> update(Integer id, ChamadoDTO objDTO) {
        Optional<Chamado> optionalChamado = repository.findById(id);

        if (optionalChamado.isPresent()) {
            Chamado oldObj = optionalChamado.get();

            Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico()).orElse(null);
            Cliente cliente = clienteService.findById(objDTO.getCliente()).orElse(null);

            oldObj.setTecnico(tecnico);
            oldObj.setCliente(cliente);
            oldObj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
            oldObj.setStatus(Status.toEnum(objDTO.getStatus()));
            oldObj.setTitulo(objDTO.getTitulo());
            oldObj.setObservacoes(objDTO.getObservacoes());

            if (oldObj.getStatus().getCodigo().equals(2)) {
                oldObj.setDataFechamento(LocalDate.now());
            }

            return Optional.of(repository.save(oldObj));
        }

        return Optional.empty();
    }
}