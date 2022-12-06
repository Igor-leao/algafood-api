package com.igor.ifood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igor.ifood.di.modelo.Cliente;
import com.igor.ifood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {

	private AtivacaoClienteService ativacaoClienteService;
	
	
	public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}


	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente igor = new Cliente("joão", "joão@joão.com", "987698237490");
		ativacaoClienteService.ativar(igor);
		return "hello";
	}
}
