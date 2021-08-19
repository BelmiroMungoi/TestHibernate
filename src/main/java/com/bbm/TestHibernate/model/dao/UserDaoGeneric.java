package com.bbm.TestHibernate.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bbm.TestHibernate.HibernateUtil;

public class UserDaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void save(E entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
	}
}
