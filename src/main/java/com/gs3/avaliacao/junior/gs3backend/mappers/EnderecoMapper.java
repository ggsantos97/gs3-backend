package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.EnderecoDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends AbstractMapper<Endereco, EnderecoDTO>{


}
