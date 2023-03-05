package com.igor.ifood.infrastructure.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.igor.ifood.domain.model.Restaurante;

public class RestauranteSpecs {
 
	public static Specification<Restaurante> comFreteGratis() {
		return (root, query, builder) ->
		builder.equal(root.get("taxafrete"), BigDecimal.ZERO);
	}
	
	public static Specification<Restaurante> comNomeSemelhante(String nome) {
		return (root, query, builder) ->
		builder.like(root.get(nome), "%" + nome +"%");
	}
}
