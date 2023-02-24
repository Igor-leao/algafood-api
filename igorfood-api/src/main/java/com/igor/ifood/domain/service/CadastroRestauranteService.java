package com.igor.ifood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.ifood.domain.exception.EntidadeNaoEncontradaException;
import com.igor.ifood.domain.model.Cozinha;
import com.igor.ifood.domain.model.Restaurante;
import com.igor.ifood.domain.repository.CozinhaRepository;
import com.igor.ifood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	 public Restaurante salvar(Restaurante restaurante) {
		 
		 Long cozinhaId = restaurante.getCozinha().getId();
		 Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				 String.format("não existe"
			 		+ "cadastro de cozinha com o código %d", cozinhaId)));
		 
		 restaurante.setCozinha(cozinha);
		 
		 return restauranteRepository.save(restaurante);
	 }
	 
	
}
