package com.example.servicos.mappers;

import com.example.servicos.domain.Tecnico;
import com.example.servicos.domain.enums.Perfil;
import com.example.servicos.dto.TecnicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    @Mapping(target = "chamados", ignore = true)
    Tecnico toEntity(TecnicoDTO dto);

    TecnicoDTO toDTO(Tecnico tecnico);

    @Mapping(target = "chamados", ignore = true)
    void updateEntityFromDTO(TecnicoDTO dto, @MappingTarget Tecnico entity);

    default Integer fromPerfil(Perfil perfil) {
        return perfil == null ? null : perfil.getCodigo();
    }

    default Perfil toPerfil(Integer codigo) {
        return codigo == null ? null : Perfil.toEnum(codigo);
    }
}