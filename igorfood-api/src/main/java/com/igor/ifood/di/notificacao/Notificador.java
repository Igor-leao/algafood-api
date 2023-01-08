package com.igor.ifood.di.notificacao;

import com.igor.ifood.di.modelo.Cliente;

public interface Notificador {
 void notificar(Cliente cliente, String mensagem);
 NotificadorProperties notificador = new NotificadorProperties();

}
