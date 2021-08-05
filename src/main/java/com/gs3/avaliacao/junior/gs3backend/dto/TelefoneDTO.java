package com.gs3.avaliacao.junior.gs3backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class TelefoneDTO implements Serializable {

    private int id;
    @JsonProperty("tipotelefone")
    private int tipoTelefone;
    @JsonProperty("numerotelefone")
    private int numeroTelefone;
    private int ddd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

//    public TelefoneDTO(int id, int tipoTelefone, int numeroTelefone, int ddd) {
//        this.id = id;
//        this.tipoTelefone = tipoTelefone;
//        this.numeroTelefone = numeroTelefone;
//        this.ddd = ddd;
//    }
}
