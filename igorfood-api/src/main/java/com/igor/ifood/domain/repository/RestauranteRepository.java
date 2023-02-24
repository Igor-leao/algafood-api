package com.igor.ifood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.ifood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository <Restaurante, Long>{

	
	//pode chamar repositorio orientado a persitencia
	
} 
