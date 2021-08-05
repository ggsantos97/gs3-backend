package com.gs3.avaliacao.junior.gs3backend.mappers;

import com.gs3.avaliacao.junior.gs3backend.dto.EmailDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper extends AbstractMapper<Email, EmailDTO> {
}
