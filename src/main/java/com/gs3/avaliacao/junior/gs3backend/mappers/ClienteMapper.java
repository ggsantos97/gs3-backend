package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper{

    //@Mapping(source = "dto.endereco", target = "endereco")
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<ClienteDTO> toDtoList(List<Cliente> entities);

}
