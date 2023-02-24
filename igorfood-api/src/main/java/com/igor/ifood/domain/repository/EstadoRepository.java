package com.igor.ifood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.ifood.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	
	//pode chamar repositorio orientado a persitencia
	
} 
