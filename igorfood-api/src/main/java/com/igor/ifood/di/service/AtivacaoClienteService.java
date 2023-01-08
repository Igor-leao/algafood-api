package com.igor.ifood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.igor.ifood.di.modelo.Cliente;
import com.igor.ifood.di.notificacao.NivelUrgencia;
import com.igor.ifood.di.notificacao.Notificador;
import com.igor.ifood.di.notificacao.NotificadorEmail;
import com.igor.ifood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
//	Opções em colocar os pontos de injeção do Notificador, todos são a mesma coisa
//	a melhor forma é no construtor, e a anotação autowired serve para dar preferência
//	ou seja uma dependencia da classe, que preciso dela
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		
		// dizer para o container que o cliente está ativo neste momento
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
		
		
	}
	
}
