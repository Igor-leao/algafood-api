package com.igor.ifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igor.ifood.domain.exception.EntidadeEmUsoException;
import com.igor.ifood.domain.exception.EntidadeNaoEncontradaException;
import com.igor.ifood.domain.model.Estado;
import com.igor.ifood.domain.model.Restaurante;
import com.igor.ifood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	public Estado buscar(Long id) {
		return estadoRepository.findById(id).orElse(null);
	}
	
	public Estado salvar (Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void remover (Long id) {		
		try {
			estadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Estado não existe!", id));
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Estado de %d, não pode ser removida pois está em uso!", id));
		}		
	}
}
