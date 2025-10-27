package com.example.servicos.repositories;

import com.example.servicos.domain.Chamado;
import com.example.servicos.domain.enums.Prioridade;
import com.example.servicos.domain.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    List<Chamado> findByStatus(Status status);
    Page<Chamado> findByStatus(Status status, Pageable pageable);
    
    List<Chamado> findByPrioridade(Prioridade prioridade);
    Page<Chamado> findByPrioridade(Prioridade prioridade, Pageable pageable);
    
    List<Chamado> findByTecnicoId(Integer tecnicoId);
    Page<Chamado> findByTecnicoId(Integer tecnicoId, Pageable pageable);
    
    List<Chamado> findByClienteId(Integer clienteId);
    Page<Chamado> findByClienteId(Integer clienteId, Pageable pageable);
    
    List<Chamado> findByDataAberturaBetween(LocalDate dataInicio, LocalDate dataFim);
    List<Chamado> findByDataFechamentoBetween(LocalDate dataInicio, LocalDate dataFim);
    
    List<Chamado> findByStatusAndPrioridade(Status status, Prioridade prioridade);
    List<Chamado> findByTecnicoIdAndStatus(Integer tecnicoId, Status status);
    List<Chamado> findByClienteIdAndStatus(Integer clienteId, Status status);
    
    @Query("SELECT c FROM Chamado c WHERE c.status = :status AND c.prioridade = :prioridade ORDER BY c.dataAbertura DESC")
    List<Chamado> findChamadosPorStatusEPrioridade(@Param("status") Status status, @Param("prioridade") Prioridade prioridade);
    
    @Query("SELECT c FROM Chamado c WHERE c.tecnico.id = :tecnicoId AND c.status != :status ORDER BY c.dataAbertura DESC")
    List<Chamado> findChamadosAtivosPorTecnico(@Param("tecnicoId") Integer tecnicoId, @Param("status") Status status);
    
    @Query("SELECT COUNT(c) FROM Chamado c WHERE c.status = :status")
    Long countByStatus(@Param("status") Status status);
    
    @Query("SELECT COUNT(c) FROM Chamado c WHERE c.tecnico.id = :tecnicoId AND c.status = :status")
    Long countByTecnicoAndStatus(@Param("tecnicoId") Integer tecnicoId, @Param("status") Status status);
    
    @Query("SELECT c FROM Chamado c WHERE c.dataAbertura >= :dataInicio AND c.dataAbertura <= :dataFim ORDER BY c.dataAbertura DESC")
    List<Chamado> findChamadosPorPeriodo(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
    
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Chamado c WHERE c.cliente.id = :clienteId AND c.status != :status")
    Boolean existsChamadoAtivoPorCliente(@Param("clienteId") Integer clienteId, @Param("status") Status status);
}