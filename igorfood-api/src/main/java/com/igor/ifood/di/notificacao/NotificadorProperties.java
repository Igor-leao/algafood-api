package com.igor.ifood.di.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

@SuppressWarnings({ "unused" })
@Component
@ConfigurationProperties("notificador.email")
@Data
public class NotificadorProperties {

	/**
	 * Host do servidor de e-mail
	 */

	private String hostServidor;

	/**
	 * Porta do servidor de e-mail
	 */
	private Integer portaServidor;
}
