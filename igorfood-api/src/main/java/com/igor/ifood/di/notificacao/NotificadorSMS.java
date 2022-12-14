package com.igor.ifood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.igor.ifood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)

@Component
public class NotificadorSMS implements Notificador{

	
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do SMS %s: %s\n",
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
}
