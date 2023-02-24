package com.igor.ifood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.igor.ifood.domain.model.Cozinha;
@Repository 
public interface CozinhaRepository  extends JpaRepository <Cozinha, Long>{

	
	//pode chamar repositorio orientado a persitencia
	List<Cozinha> nome(String nome);
	
	
} 
