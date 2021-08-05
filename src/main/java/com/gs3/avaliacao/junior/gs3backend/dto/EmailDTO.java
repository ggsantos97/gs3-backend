package com.gs3.avaliacao.junior.gs3backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.io.Serializable;


public class EmailDTO implements Serializable {

    private long id;
    @Email
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

//    public EmailDTO(@Email String endereco) {
//        this.endereco = endereco;
//    }
}
