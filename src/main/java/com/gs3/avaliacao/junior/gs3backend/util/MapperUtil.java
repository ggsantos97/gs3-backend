package com.gs3.avaliacao.junior.gs3backend.util;

import com.gs3.avaliacao.junior.gs3backend.dto.ClienteDTO;
import com.gs3.avaliacao.junior.gs3backend.dto.EmailDTO;
import com.gs3.avaliacao.junior.gs3backend.dto.EnderecoDTO;
import com.gs3.avaliacao.junior.gs3backend.dto.TelefoneDTO;
import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import com.gs3.avaliacao.junior.gs3backend.entity.Email;
import com.gs3.avaliacao.junior.gs3backend.entity.Endereco;
import com.gs3.avaliacao.junior.gs3backend.entity.Telefone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapperUtil {

    private MapperUtil(){}
    public static void updateModelCliente(ClienteDTO dto, Cliente cliente){
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.getEndereco().setCep(dto.getEndereco().getCep());
        cliente.getEndereco().setCidade(dto.getEndereco().getCidade());
        cliente.getEndereco().setBairro(dto.getEndereco().getBairro());
        cliente.getEndereco().setComplemento(dto.getEndereco().getComplemento());
        cliente.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());
        cliente.getEndereco().setUf(dto.getEndereco().getUf());
        cliente.getEmails().clear();
        cliente.getTelefones().clear();
        cliente.getTelefones().addAll(telefoneDTOSetToTelefoneSet(dto.getTelefones()));
         cliente.getEmails().addAll(emailDTOSetToEmailSet(dto.getEmails()));
    }

    public static void updateModelEmail(Set<EmailDTO> dtos, Set<Email> emails){
        for(EmailDTO dto: dtos){
           // emails.add( dtos)
        }


    }
    public static void UpdateModelTelefone(Set<TelefoneDTO> dtos, Set<Telefone> telefones){
        for(TelefoneDTO dto : dtos){
            for(Telefone telefone: telefones){
                telefone.setDdd(dto.getDdd());
            }
        }
    }


    public static Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( dto.getId() );
        cliente.setNome( dto.getNome() );
        cliente.setCpf( dto.getCpf() );
        cliente.setEndereco( enderecoDTOToEndereco( dto.getEndereco() ) );
        cliente.setTelefones( telefoneDTOSetToTelefoneSet( dto.getTelefones() ) );
        cliente.setEmails( emailDTOSetToEmailSet( dto.getEmails() ) );
        cliente.getEndereco().setCliente(cliente);
        return cliente;
    }

    public static ClienteDTO toDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }
        entity.getEndereco().setCliente(null);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId( entity.getId() );
        clienteDTO.setNome( entity.getNome() );
        clienteDTO.setCpf( entity.getCpf() );
        clienteDTO.setEndereco( enderecoToEnderecoDTO( entity.getEndereco() ) );
        clienteDTO.setTelefones( telefoneSetToTelefoneDTOSet( entity.getTelefones() ) );
        clienteDTO.setEmails( emailSetToEmailDTOSet( entity.getEmails() ) );

        return clienteDTO;
    }

    public static List<ClienteDTO> toDtoList(List<Cliente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( entities.size() );
        for ( Cliente cliente : entities ) {
            cliente.getEndereco().setCliente(null);
            list.add( toDTO( cliente ) );
        }

        return list;
    }

    protected static Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( enderecoDTO.getId() );
        endereco.setCep( enderecoDTO.getCep() );
        endereco.setLogradouro( enderecoDTO.getLogradouro() );
        endereco.setBairro( enderecoDTO.getBairro() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setUf( enderecoDTO.getUf() );
        endereco.setComplemento( enderecoDTO.getComplemento() );
        endereco.setCliente( toEntity( enderecoDTO.getCliente() ) );

        return endereco;
    }

    protected static Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        Telefone telefone = new Telefone();

        telefone.setId( telefoneDTO.getId() );
        telefone.setTipoTelefone( telefoneDTO.getTipoTelefone() );
        telefone.setNumeroTelefone( telefoneDTO.getNumeroTelefone() );
        telefone.setDdd( telefoneDTO.getDdd() );

        return telefone;
    }

    protected static Set<Telefone> telefoneDTOSetToTelefoneSet(Set<TelefoneDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Telefone> set1 = new HashSet<Telefone>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TelefoneDTO telefoneDTO : set ) {
            set1.add( telefoneDTOToTelefone( telefoneDTO ) );
        }

        return set1;
    }

    protected static  Email emailDTOToEmail(EmailDTO emailDTO) {
        if ( emailDTO == null ) {
            return null;
        }

        Email email = new Email();

        email.setEndereco( emailDTO.getEndereco() );

        return email;
    }

    protected static Set<Email> emailDTOSetToEmailSet(Set<EmailDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Email> set1 = new HashSet<Email>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( EmailDTO emailDTO : set ) {
            set1.add( emailDTOToEmail( emailDTO ) );
        }

        return set1;
    }

    protected static EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId( endereco.getId() );
        enderecoDTO.setCep( endereco.getCep() );
        enderecoDTO.setLogradouro( endereco.getLogradouro() );
        enderecoDTO.setBairro( endereco.getBairro() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setUf( endereco.getUf() );
        enderecoDTO.setComplemento( endereco.getComplemento() );
        enderecoDTO.setCliente( toDTO( endereco.getCliente() ) );

        return enderecoDTO;
    }

    protected static TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTO telefoneDTO = new TelefoneDTO();

        telefoneDTO.setId( telefone.getId() );
        telefoneDTO.setTipoTelefone( telefone.getTipoTelefone() );
        telefoneDTO.setNumeroTelefone( telefone.getNumeroTelefone() );
        telefoneDTO.setDdd( telefone.getDdd() );

        return telefoneDTO;
    }

    protected static Set<TelefoneDTO> telefoneSetToTelefoneDTOSet(Set<Telefone> set) {
        if ( set == null ) {
            return null;
        }

        Set<TelefoneDTO> set1 = new HashSet<TelefoneDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Telefone telefone : set ) {
            set1.add( telefoneToTelefoneDTO( telefone ) );
        }

        return set1;
    }

    protected static EmailDTO emailToEmailDTO(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setEndereco( email.getEndereco() );
        emailDTO.setId(email.getId());
        return emailDTO;
    }

    protected static Set<EmailDTO> emailSetToEmailDTOSet(Set<Email> set) {
        if ( set == null ) {
            return null;
        }

        Set<EmailDTO> set1 = new HashSet<EmailDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Email email : set ) {
            set1.add( emailToEmailDTO( email ) );
        }

        return set1;
    }
}
