package com.igor.ifood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.igor.ifood.di.modelo.Cliente;
import com.igor.ifood.di.notificacao.Notificador;
import com.igor.ifood.di.notificacao.NotificadorEmail;

@Component
public class AtivacaoClienteService {
//	Opções em colocar os pontos de injeção do Notificador, todos são a mesma coisa
//	a melhor forma é no construtor, e a anotação autowired serve para dar preferência
//	ou seja uma dependencia da classe, que preciso dela
	@Qualifier("email")
	@Autowired
	private Notificador notificador;
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "seu cadastro do sistema está ativado");
	}
	
}
