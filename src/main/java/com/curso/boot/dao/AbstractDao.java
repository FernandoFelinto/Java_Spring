package com.curso.boot.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public abstract class AbstractDao <T, PK extends Serializable> {
	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = 
			(Class<T>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void salvar(T entity) { 

		entityManager.persist(entity);
	}
	
	public void editar(T entity) {
		
		entityManager.merge(entity);
	}
	
	public void excluir(PK id) {
		
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T buscaPorId(PK id) {
		
		return entityManager.find(entityClass, id);
	}
	
	public List<T> buscarTodos() {
		
		return entityManager
				.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();
	}	
	
	protected List<T> createQuery(String jpql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
		    query.setParameter(i+1, params[i]);
        }
    	return query.getResultList();
	}
}
