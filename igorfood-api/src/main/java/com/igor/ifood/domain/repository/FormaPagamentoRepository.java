package com.igor.ifood.domain.repository;

import java.util.List;

import com.igor.ifood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	
	//pode chamar repositorio orientado a persitencia
	List <FormaPagamento> listar(); 
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento FormaPagamento);
	void remover(FormaPagamento FormaPagamento);
	
} 
