package com.bbm.TestHibernate;

import java.util.List;

import org.junit.Test;

import com.bbm.TestHibernate.model.EntityUser;
import com.bbm.TestHibernate.model.dao.UserDaoGeneric;

public class TestHibernate {

	@Test
	public void testHibernate() {
		HibernateUtil.getEntityManager();
	}

	@Test
	public void save() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();

		EntityUser entityUser = new EntityUser();
		entityUser.setFirstName("Stela");
		entityUser.setLastName("Ana");
		entityUser.setEmail("ansa@email.com");
		entityUser.setUserName("stela");
		entityUser.setPassword("13675");

		user.save(entityUser);
	}

	@Test
	public void search() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		EntityUser entityUser = new EntityUser();
		entityUser.setIdUser(2L);
		entityUser = user.search(entityUser);
		System.out.println(entityUser);
	}

	@Test
	public void update() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		EntityUser entityUser = user.search(5L, EntityUser.class);

		entityUser.setFirstName("No Name For me");
		entityUser.setLastName("Atualizdo");

		entityUser = user.updateMerge(entityUser);

		System.out.println(entityUser);
	}

	@Test
	public void delete() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		EntityUser entityUser = user.search(4L, EntityUser.class);
		user.deleteById(entityUser);
	}

	@Test
	public void findAll() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		List<EntityUser> list = user.findAll(EntityUser.class);

		for (EntityUser entityUser : list) {
			System.out.println(entityUser);
			System.out.println("--------------------------");
		}
	}

	@Test
	public void testQuery() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		// cria uma nova query de busca
		List<EntityUser> list = user.getEntityManager().createQuery("from EntityUser where id = 3").getResultList();

		for (EntityUser entityUser : list) {
			System.out.println(entityUser);
		}
	}

	@Test
	public void testQueryMaxResult() {
		UserDaoGeneric<EntityUser> user = new UserDaoGeneric<EntityUser>();
		// cria uma nova query de busca e limita o numero de dados retornados
		List<EntityUser> list = user.getEntityManager().createQuery("from EntityUser order by firstName").setMaxResults(3)
				.getResultList();

		for (EntityUser entityUser : list) {
			System.out.println(entityUser);
		}
	}
}
