package com.bbm.TestHibernate.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bbm.TestHibernate.HibernateUtil;

public class UserDaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	// Metodo para a insercao de dados na base de dados
	public void save(E entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
	}

	// Metodo para a busca de dados na base de dados
	public E search(E entity) {
		Object id = HibernateUtil.getPrimaryKey(entity);
		E e = (E) entityManager.find(entity.getClass(), id);
		return e;
	}

	// Metodo para a busca de dados a serem atualizados
	public E search(Long id, Class<E> entity) {
		E e = (E) entityManager.find(entity, id);
		return e;
	}

	// Metodo para a atualizacao de dados
	public E updateMerge(E entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E savedEntity = entityManager.merge(entity);
		transaction.commit();

		return savedEntity;
	}

	// Metodo para deletar os dados da base de dados
	public void deleteById(E entity) {
		Object id = HibernateUtil.getPrimaryKey(entity);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager
				.createNativeQuery(
						"delete from " + entity.getClass().getSimpleName().toLowerCase() + " where idUser =" + id)
				.executeUpdate();
		transaction.commit();
	}
}
