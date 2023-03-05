package com.igor.ifood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igor.ifood.domain.exception.CozinhaNaoEncontradaException;
import com.igor.ifood.domain.exception.EntidadeEmUsoException;
import com.igor.ifood.domain.exception.EntidadeNaoEncontradaException;
import com.igor.ifood.domain.model.Cozinha;
import com.igor.ifood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	private static final String MSG_COZINHA_EM_USO 
	= "Cozinha de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {

		try {
			return cozinhaRepository.save(cozinha);
		} catch (EmptyResultDataAccessException e) {
			throw new CozinhaNaoEncontradaException(1L);
		
		}
	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new CozinhaNaoEncontradaException(cozinhaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_COZINHA_EM_USO, cozinhaId));
		}
	}
}
