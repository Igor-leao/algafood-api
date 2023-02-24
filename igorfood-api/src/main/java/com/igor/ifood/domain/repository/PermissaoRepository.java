package com.igor.ifood.domain.repository;

import java.util.List;

import com.igor.ifood.domain.model.Permissao;

public interface PermissaoRepository {

	
	//pode chamar repositorio orientado a persitencia
	List <Permissao> listar(); 
	Permissao buscar(Long id);
	Permissao salvar(Permissao Permissao);
	void remover(Permissao Permissao);
	
} 
