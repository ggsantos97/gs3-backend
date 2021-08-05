package com.gs3.avaliacao.junior.gs3backend.exception;

//@Getter
//@Setter
public enum EnumMensagens {
    ERRO_APLICACAO("000","Erro ao executar"),
    NENHUM_CLIENTE_ENCONTRADO("001", "Nenhum Cliente encontrado na Base!");

    String  codigo;
    String  mensagem;

    EnumMensagens( String codigo,String mensagem){
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
