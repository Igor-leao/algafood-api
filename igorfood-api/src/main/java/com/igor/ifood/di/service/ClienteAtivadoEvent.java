package com.igor.ifood.di.service;

import com.igor.ifood.di.modelo.Cliente;

public class ClienteAtivadoEvent {


	private Cliente cliente;
public ClienteAtivadoEvent(Cliente cliente) {
	super();
	this.cliente = cliente;
}
public Cliente getCliente() {
	return cliente;
}

}