package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, TelefoneMapper.class, EmailMapper.class})
public interface ClienteMapper extends AbstractMapper<Cliente, ClienteDTO>{

    @Override
    Cliente toEntity(ClienteDTO dto);

    @Override
    ClienteDTO toDTO(Cliente entity);
}
