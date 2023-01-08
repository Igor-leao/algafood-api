package com.igor.ifood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.igor.ifood.di.notificacao.NotificadorProperties;
import com.igor.ifood.di.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {
	
	
	@Autowired
	private NotificadorProperties properties;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("host "+ properties.getHostServidor());
		System.out.println("Porta  "+ properties.getPortaServidor());
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}
}
