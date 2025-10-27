package com.example.servicos.mappers;

import com.example.servicos.domain.Cliente;
import com.example.servicos.domain.enums.Perfil;
import com.example.servicos.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "chamados", ignore = true)
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente cliente);

    @Mapping(target = "chamados", ignore = true)
    void updateEntityFromDTO(ClienteDTO dto, @MappingTarget Cliente entity);

    default Integer fromPerfil(Perfil perfil) {
        return perfil == null ? null : perfil.getCodigo();
    }

    default Perfil toPerfil(Integer codigo) {
        return codigo == null ? null : Perfil.toEnum(codigo);
    }
}