package com.example.servicos.mappers;

import com.example.servicos.domain.Chamado;
import com.example.servicos.domain.enums.Prioridade;
import com.example.servicos.domain.enums.Status;
import com.example.servicos.dto.ChamadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    @Mappings({
            @Mapping(source = "prioridade", target = "prioridade"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "tecnico.id", target = "tecnico"),
            @Mapping(source = "cliente.id", target = "cliente"),
            @Mapping(source = "tecnico.nome", target = "nomeTecnico"),
            @Mapping(source = "cliente.nome", target = "nomeCliente")
    })
    ChamadoDTO toDTO(Chamado chamado);

    @Mappings({
            @Mapping(target = "tecnico", ignore = true),
            @Mapping(target = "cliente", ignore = true)
    })
    Chamado toEntity(ChamadoDTO dto);

    default Integer fromPrioridade(Prioridade prioridade) {
        return prioridade == null ? null : prioridade.getCodigo();
    }

    default Prioridade toPrioridade(Integer codigo) {
        return codigo == null ? null : Prioridade.toEnum(codigo);
    }

    default Integer fromStatus(Status status) {
        return status == null ? null : status.getCodigo();
    }

    default Status toStatus(Integer codigo) {
        return codigo == null ? null : Status.toEnum(codigo);
    }
}
