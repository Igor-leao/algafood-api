package com.igor.ifood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.igor.ifood.domain.model.Permissao;
import com.igor.ifood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Permissao> listar() {
		TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);

		return query.getResultList();

	}

	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Transactional
	@Override
	public Permissao salvar(Permissao Permissao) {
		return manager.merge(Permissao);
	}

	@Transactional
	@Override
	public void remover(Permissao Permissao) {
		Permissao = buscar(Permissao.getId());
		manager.remove(Permissao);
	}

}
