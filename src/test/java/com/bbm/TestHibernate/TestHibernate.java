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
}
