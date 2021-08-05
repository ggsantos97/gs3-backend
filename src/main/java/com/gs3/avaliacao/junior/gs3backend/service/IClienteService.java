package com.gs3.avaliacao.junior.gs3backend.service;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import com.gs3.avaliacao.junior.gs3backend.exception.ErroNegocialException;

import java.util.List;

public interface IClienteService {
     List<ClienteDTO> buscaTodos() throws ErroNegocialException;
     ClienteDTO salva(ClienteDTO dto) throws ErroNegocialException;
     ClienteDTO atualiza(ClienteDTO dto, long id) throws ErroNegocialException;;
     String exclui(long id) throws ErroNegocialException;
}
