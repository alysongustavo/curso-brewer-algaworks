package br.com.alyson.brewer.service.exception;

public class NegocioException extends RuntimeException{

    public NegocioException(String mensagem){
        super(mensagem);
    }
}
