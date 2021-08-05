package com.gs3.avaliacao.junior.gs3backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;

    @NotBlank(message = "Nome Obrigatório")
    @Size(min=3, max=100)
    private String nome;

    @NotBlank(message = "CPF Obrigatório")
    private String cpf;

    //@NotNull
    private EnderecoDTO endereco;

    //@NotNull
    private Set<TelefoneDTO> telefones;

    @NotEmpty
    private Set<EmailDTO> emails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Set<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public Set<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(Set<EmailDTO> emails) {
        this.emails = emails;
    }
}
