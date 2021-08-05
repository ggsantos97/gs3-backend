package com.gs3.avaliacao.junior.gs3backend.service;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import com.gs3.avaliacao.junior.gs3backend.exception.EnumMensagens;
import com.gs3.avaliacao.junior.gs3backend.exception.ErroNegocialException;
import com.gs3.avaliacao.junior.gs3backend.mappers.ClienteMapper;
import com.gs3.avaliacao.junior.gs3backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;

    public List<ClienteDTO> buscaTodos() throws ErroNegocialException{
        List<Cliente> clientes = repository.findAll();
        if(clientes.isEmpty()){
            throw new ErroNegocialException(EnumMensagens.NENHUM_CLIENTE_ENCONTRADO);
        }
        return mapper.toDtoList(clientes);
    }

    @Override
    public ClienteDTO salvaOuAtualiza(ClienteDTO dto) throws ErroNegocialException{
       try {
        Cliente entity = mapper.toEntity(dto);
          return mapper.toDTO(repository.save(entity));
       } catch (Exception ex){
           throw new ErroNegocialException(ex.getMessage(), ex.getCause().getLocalizedMessage());
       }

    }

    @Override
    public void exclui(long id)throws ErroNegocialException{

    }
}
