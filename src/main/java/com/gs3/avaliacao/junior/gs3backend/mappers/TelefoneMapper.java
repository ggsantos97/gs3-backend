package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.TelefoneDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper extends AbstractMapper<Telefone, TelefoneDTO>{

}
