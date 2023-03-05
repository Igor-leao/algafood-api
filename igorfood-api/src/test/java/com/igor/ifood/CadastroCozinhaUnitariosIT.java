package com.igor.ifood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.igor.ifood.domain.exception.CozinhaNaoEncontradaException;
import com.igor.ifood.domain.exception.EntidadeEmUsoException;
import com.igor.ifood.domain.model.Cozinha;
import com.igor.ifood.domain.service.CadastroCozinhaService;

@SpringBootTest
public class CadastroCozinhaUnitariosIT {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Test
	public void testarCadastroCozinhaComSucesso() {
		
//		gieverJaExisteCozinhaChinesa_whenCadastroCozinhaChinesa_thenDeveFalhar
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test
	public void testarCadastroCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					cadastroCozinha.salvar(novaCozinha);
				});

		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		EntidadeEmUsoException erroEsperado =
				Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
						cadastroCozinha.excluir(1L);
				});
		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
public void deveFalhar_QuandoExcluirCozinhaInexistente() {
	CozinhaNaoEncontradaException erroEsperado =
			Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
				cadastroCozinha.excluir(100L);
			});

	assertThat(erroEsperado).isNotNull();
	}

}