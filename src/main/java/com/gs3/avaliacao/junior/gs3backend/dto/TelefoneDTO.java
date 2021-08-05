package com.gs3.avaliacao.junior.gs3backend.dto;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class TelefoneDTO {

    private int id;
    private int tipoTelefone;
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
}
