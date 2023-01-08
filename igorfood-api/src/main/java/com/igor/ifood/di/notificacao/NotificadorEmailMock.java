package com.igor.ifood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.igor.ifood.di.modelo.Cliente;


@Component
public class NotificadorEmailMock implements Notificador {
	
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		
		System.out.printf("MOCK: Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
}
