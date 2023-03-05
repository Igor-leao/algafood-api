package com.igor.ifood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.igor.ifood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxafreteFinal);

}