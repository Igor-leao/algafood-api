package com.igor.ifood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
