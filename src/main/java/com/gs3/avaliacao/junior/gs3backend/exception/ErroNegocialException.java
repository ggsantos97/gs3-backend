package com.gs3.avaliacao.junior.gs3backend.exception;

public class ErroNegocialException extends Exception {

    private String message;
    private String cause;
    private String classe;

    public ErroNegocialException() { }

    public ErroNegocialException(String message, String cause){
        this.message = message;
        this.cause = cause;
    }
    public ErroNegocialException(EnumMensagens enumMensagens){
        super(enumMensagens.getMensagem());
    }
}
