package com.igor.ifood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igor.ifood.domain.exception.EntidadeEmUsoException;
import com.igor.ifood.domain.exception.EntidadeNaoEncontradaException;
import com.igor.ifood.domain.model.Estado;
import com.igor.ifood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@GetMapping
	public List<Estado> listar(){
		return cadastroEstado.listar();
	}
	
	@GetMapping(value = "{estadoId}")
	public ResponseEntity<Estado> buscarId (@PathVariable Long estadoId){
		Estado estado = cadastroEstado.buscar(estadoId);
		
		if (estado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estado);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar (@RequestBody Estado estado){
		return cadastroEstado.salvar(estado);	
	}
	
	@DeleteMapping("{estadoId}")
	public ResponseEntity<Estado> deletar (@PathVariable Long estadoId) {
		try {
			cadastroEstado.remover(estadoId);
			
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build(); 
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}		
		
	}
	
	@PutMapping("{estadoId}")
	public ResponseEntity<Estado> atualizar (@RequestBody Estado estado, @PathVariable Long estadoId){
		
		Estado estadoAtual = cadastroEstado.buscar(estadoId);
		
		if(estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			
			estadoAtual = cadastroEstado.salvar(estadoAtual);
			
			return ResponseEntity.ok(estadoAtual);
		}
		
		return ResponseEntity.notFound().build(); 
	}
}
