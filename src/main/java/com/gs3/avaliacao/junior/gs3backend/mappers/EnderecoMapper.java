package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.EnderecoDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {


    @Mapping(source = "cliente", target = "cliente")
    Endereco toEntity(EnderecoDTO dto);


    //@Mapping(source = "entity.endereco", target = "")
    EnderecoDTO toDTO(Endereco entity);
}
