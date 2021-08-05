package com.gs3.avaliacao.junior.gs3backend.service;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import com.gs3.avaliacao.junior.gs3backend.exception.EnumMensagens;
import com.gs3.avaliacao.junior.gs3backend.exception.ErroNegocialException;
import com.gs3.avaliacao.junior.gs3backend.mappers.ClienteMapper;
import com.gs3.avaliacao.junior.gs3backend.mappers.EnderecoMapper;
import com.gs3.avaliacao.junior.gs3backend.repository.ClienteRepository;
import com.gs3.avaliacao.junior.gs3backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;
    @Autowired
    EnderecoMapper enderecoMapper;

    public List<ClienteDTO> buscaTodos() throws ErroNegocialException{
        List<Cliente> clientes = repository.findAll();
        if(clientes.isEmpty()){
            throw new ErroNegocialException(EnumMensagens.NENHUM_CLIENTE_ENCONTRADO);
        }
        List<ClienteDTO> dtos = MapperUtil.toDtoList(clientes);
        return dtos;
    }

    @Override
    public ClienteDTO salva(ClienteDTO dto) throws ErroNegocialException{
       try {
        Cliente entity = MapperUtil.toEntity(dto);
        //entity.getEndereco().setCliente(entity);
           entity = repository.save(entity);
          return MapperUtil.toDTO(entity);
       } catch (Exception ex){
           throw new ErroNegocialException(ex.getMessage(), ex.getCause().getLocalizedMessage());
       }

    }

    @Override
    public ClienteDTO atualiza(ClienteDTO dto, long id) throws ErroNegocialException {
      Optional<Cliente> cliente = repository.findById(id);
      if(cliente.isPresent()){
          MapperUtil.updateModelCliente(dto, cliente.get());
        Cliente retorno =  repository.save(cliente.get());
        return MapperUtil.toDTO(retorno);
      } else {
          throw new ErroNegocialException(EnumMensagens.NENHUM_CLIENTE_ENCONTRADO);
      }
    }

    @Override
    public String exclui(long id)throws ErroNegocialException{
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
            repository.delete(cliente.get());
            return "Cliente Excluído com sucesso!";
        } else {
            throw new ErroNegocialException(EnumMensagens.NENHUM_CLIENTE_ENCONTRADO);
        }
    }
}
