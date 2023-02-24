package com.igor.ifood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igor.ifood.domain.exception.EntidadeNaoEncontradaException;
import com.igor.ifood.domain.model.Cidade;
import com.igor.ifood.domain.model.Estado;
import com.igor.ifood.domain.repository.CidadeRepository;
import com.igor.ifood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Cidade> listar(){
		return cidadeRepository.findAll();				
	}
	
	public Cidade salvar (Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId).orElse(null);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de Estado com o ID: %d", estadoId));
		}
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public Cidade buscar(Long id) {
		return cidadeRepository.findById(id).orElse(null);
	}
	
	public void deletar (Long id) {
		try {
			cidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Cidade não existe!", id));
		}		
	}
}
