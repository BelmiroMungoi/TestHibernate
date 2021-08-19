package com.bbm.TestHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory factory = null;

	static {
		init();
	}

	// metodo para inicializar a conexao com o ficheiro persistence.xml
	private static void init() {

		try {
			
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("TestHibernate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); // Provem a persistencia de dados
	}

	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
