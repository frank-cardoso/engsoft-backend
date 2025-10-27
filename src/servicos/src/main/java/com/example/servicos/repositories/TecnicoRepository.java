package com.example.servicos.repositories;

import com.example.servicos.domain.Tecnico;
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
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

    Optional<Tecnico> findByCpf(String cpf);
    Optional<Tecnico> findByEmail(String email);
    
    List<Tecnico> findByNomeContainingIgnoreCase(String nome);
    Page<Tecnico> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    
    List<Tecnico> findByDataCriacaoBetween(LocalDate dataInicio, LocalDate dataFim);
    List<Tecnico> findByDataCriacaoAfter(LocalDate data);
    List<Tecnico> findByDataCriacaoBefore(LocalDate data);
    
    @Query("SELECT t FROM Tecnico t WHERE t.nome LIKE %:nome% ORDER BY t.nome ASC")
    List<Tecnico> buscarTecnicosPorNome(@Param("nome") String nome);
    
    @Query("SELECT t FROM Tecnico t WHERE t.dataCriacao >= :dataInicio AND t.dataCriacao <= :dataFim ORDER BY t.dataCriacao DESC")
    List<Tecnico> buscarTecnicosPorPeriodo(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
    
    @Query("SELECT COUNT(t) FROM Tecnico t WHERE t.dataCriacao >= :data")
    Long countTecnicosCriadosApos(@Param("data") LocalDate data);
    
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Tecnico t WHERE t.cpf = :cpf AND t.id != :id")
    Boolean existsByCpfAndIdNot(@Param("cpf") String cpf, @Param("id") Integer id);
    
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Tecnico t WHERE t.email = :email AND t.id != :id")
    Boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") Integer id);
    
    @Query("SELECT DISTINCT t FROM Tecnico t JOIN t.chamados ch")
    List<Tecnico> findTecnicosComChamados();
    
    @Query("SELECT t FROM Tecnico t LEFT JOIN t.chamados ch WHERE ch IS NULL")
    List<Tecnico> findTecnicosSemChamados();
    
    @Query("SELECT t, COUNT(ch) FROM Tecnico t LEFT JOIN t.chamados ch GROUP BY t ORDER BY COUNT(ch) DESC")
    List<Object[]> countChamadosPorTecnico();
    
    @Query("SELECT t FROM Tecnico t LEFT JOIN t.chamados ch GROUP BY t ORDER BY COUNT(ch) DESC")
    List<Tecnico> findTecnicosMaisAtivos();
    
    @Query("SELECT t FROM Tecnico t LEFT JOIN t.chamados ch WHERE ch IS NULL OR ch.status = :statusEncerrado")
    List<Tecnico> findTecnicosDisponiveis(@Param("statusEncerrado") String statusEncerrado);
}