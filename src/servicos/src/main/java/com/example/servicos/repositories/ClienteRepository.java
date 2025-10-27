package com.example.servicos.repositories;

import com.example.servicos.domain.Cliente;
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
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByEmail(String email);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    Page<Cliente> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    List<Cliente> findByDataCriacaoBetween(LocalDate dataInicio, LocalDate dataFim);
    List<Cliente> findByDataCriacaoAfter(LocalDate data);
    List<Cliente> findByDataCriacaoBefore(LocalDate data);

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome% ORDER BY c.nome ASC")
    List<Cliente> buscarClientesPorNome(@Param("nome") String nome);
    
    @Query("SELECT c FROM Cliente c WHERE c.dataCriacao >= :dataInicio AND c.dataCriacao <= :dataFim ORDER BY c.dataCriacao DESC")
    List<Cliente> buscarClientesPorPeriodo(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
    
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.dataCriacao >= :data")
    Long countClientesCriadosApos(@Param("data") LocalDate data);
    
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Cliente c WHERE c.cpf = :cpf AND c.id != :id")
    Boolean existsByCpfAndIdNot(@Param("cpf") String cpf, @Param("id") Integer id);
    
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Cliente c WHERE c.email = :email AND c.id != :id")
    Boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") Integer id);
    
    @Query("SELECT DISTINCT c FROM Cliente c JOIN c.chamados ch")
    List<Cliente> findClientesComChamados();
    
    @Query("SELECT c FROM Cliente c LEFT JOIN c.chamados ch WHERE ch IS NULL")
    List<Cliente> findClientesSemChamados();
    
    @Query("SELECT c, COUNT(ch) FROM Cliente c LEFT JOIN c.chamados ch GROUP BY c ORDER BY COUNT(ch) DESC")
    List<Object[]> countChamadosPorCliente();
}