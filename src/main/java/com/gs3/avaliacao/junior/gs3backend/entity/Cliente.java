package com.gs3.avaliacao.junior.gs3backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Table
@Entity
public class Cliente implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(length = 100)
    private String nome;

    @Column
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    @NotNull
    private Endereco endereco;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cliente_FK")
    //@NoEmpty
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cliente_FK")
    //@NotNull
    private Set<Email> emails = new HashSet<>();

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
}
