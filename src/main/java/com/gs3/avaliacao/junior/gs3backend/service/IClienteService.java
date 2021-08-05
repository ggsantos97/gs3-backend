package com.gs3.avaliacao.junior.gs3backend.service;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.exception.ErroNegocialException;

import java.util.List;

public interface IClienteService {
    public List<ClienteDTO> buscaTodos() throws ErroNegocialException;
    public ClienteDTO salvaOuAtualiza(ClienteDTO dto) throws ErroNegocialException;
    public void exclui(long id) throws ErroNegocialException;
}
