package com.gs3.avaliacao.junior.gs3backend.controller;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.dto.EmailDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import com.gs3.avaliacao.junior.gs3backend.exception.ErroNegocialException;
import com.gs3.avaliacao.junior.gs3backend.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(produces = "aplication/json")
    @ApiOperation(value = "Retorna uma Lista de Clientes",
                response = Cliente.class,
                responseContainer = "List"
                )
    @ResponseBody
    public ResponseEntity<List<ClienteDTO>> buscaTodosClientes() throws ErroNegocialException {
        return new ResponseEntity<>(service.buscaTodos(), HttpStatus.OK);
    }
    @ApiOperation(value = "Salva um novo Cliente")
    @ApiResponse(code = 201, message = "Retorna um novo cliente")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> salvaOuAtualizaCliente(@RequestBody Cliente dto) throws ErroNegocialException {
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
        //return new ResponseEntity<>(service.salvaOuAtualiza(dto), HttpStatus.CREATED);
    }
    @PostMapping(path = "/teste",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmailDTO teste(@RequestBody EmailDTO dto){
        return  dto;
    }
}
