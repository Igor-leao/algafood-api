package com.igor.ifood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.ifood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	
	//pode chamar repositorio orientado a persitencia
	
} 
