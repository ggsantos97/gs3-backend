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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST Clientes")
@RestController
@RequestMapping("/clientes")
@CrossOrigin( origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService service;

    //@PreAuthorize("hasRole('ADMIN','USER')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retorna uma Lista de Clientes")
    @ResponseBody
    public ResponseEntity<List<ClienteDTO>> buscaTodosClientes() throws ErroNegocialException {
        return new ResponseEntity<>(service.buscaTodos(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Salva um novo Cliente")
    @ApiResponse(code = 201, message = "Retorna um novo cliente")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> salva(@Valid @RequestBody ClienteDTO dto) throws ErroNegocialException {
        return new ResponseEntity<>(service.salva(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Atualiza um Cliente")
    @ApiResponse(code = 204, message = "Retorna um novo cliente")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
           path = "/{id}")
    public ResponseEntity<ClienteDTO> atualiza(@Valid @RequestBody ClienteDTO dto, @PathVariable("id") long id) throws ErroNegocialException {
        return new ResponseEntity<>(service.atualiza(dto, id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Exclui um Cliente")
    @ApiResponse(code = 204, message = "Exclui um cliente")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}")
    public ResponseEntity<String> exclui(@PathVariable("id") long id) throws ErroNegocialException {
        return new ResponseEntity<>(service.exclui( id), HttpStatus.NO_CONTENT);
    }

}
