package com.bbm.TestHibernate;

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
		entityUser.setFirstName("aadsd");
		entityUser.setLastName("Muas");
		entityUser.setEmail("bimas@email.com");
		entityUser.setUserName("oakasday");
		entityUser.setPassword("1234");

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
}
