package hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PersistenceManager {

	private static EntityManagerFactory emf;

	private static final ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();

	private static final ThreadLocal<EntityTransaction> threadTransaction = new ThreadLocal<EntityTransaction>();

	static {
		try {
			emf = Persistence.createEntityManagerFactory("hibernate");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() throws DatabaseException {
		EntityManager em = entityManager.get();
		if (em == null) {
			try {
				em = emf.createEntityManager();
				entityManager.set(em);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DatabaseException(e);
			}
		}
		return em;
	}

	public static void close() throws DatabaseException {
		try {
			EntityManager em = entityManager.get();
			entityManager.set(null);
			if (em != null && em.isOpen()) {
				em.close();
			}
		} catch (HibernateException e) {
			throw new DatabaseException(e);
		}
	}

	public static void beginTransaction() throws DatabaseException {
		try {
			EntityTransaction tx = threadTransaction.get();
			if (tx == null) {
				tx = getEntityManager().getTransaction();
				threadTransaction.set(tx);
			}
			tx.begin();
		} catch (HibernateException e) {
			throw new DatabaseException(e);
		}
	}

	public static void commitTransaction() throws DatabaseException {
		EntityTransaction tx = threadTransaction.get();
		try {
			if (tx != null && tx.isActive()) {
				tx.commit();
				threadTransaction.set(null);
			}
		} catch (HibernateException e) {
			rollbackTransaction();
			throw new DatabaseException(e);
		}
	}

	public static void rollbackTransaction() throws DatabaseException {
		EntityTransaction tx = threadTransaction.get();
		try {
			threadTransaction.set(null);
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} catch (HibernateException e) {
			throw new DatabaseException(e);
		} finally {
			close();
		}
	}

	public static void persist(Object pojo) throws DatabaseException {
		try {
			getEntityManager().persist(pojo);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static <T> T merge(T pojo) throws DatabaseException {
		try {
			return getEntityManager().merge(pojo);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static void remove(Object pojo) throws DatabaseException {
		try {
			getEntityManager().remove(pojo);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static <T> T find(Class<T> entityClass, Object primaryKey) throws DatabaseException {
		try {
			return getEntityManager().find(entityClass, primaryKey);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static void evict(Object pojo) throws DatabaseException {
		try {
			Session session = (Session) getEntityManager().getDelegate();
			session.evict(pojo);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	/**
	 * Get an instance, whose state may be lazily fetched.
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param primaryKey
	 * @return
	 * @throws DatabaseException
	 */
	public static <T> T getReference(Class<T> entityClass, Object primaryKey) throws DatabaseException {
		try {
			return getEntityManager().getReference(entityClass, primaryKey);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static Query createQuery(String qlString) throws DatabaseException {
		try {
			return getEntityManager().createQuery(qlString);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) throws DatabaseException {
		try {
			return getEntityManager().createQuery(criteriaQuery);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) throws DatabaseException {
		try {
			return getEntityManager().createQuery(qlString, resultClass);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static Query createNativeQuery(String sqlString) throws DatabaseException {
		try {
			return getEntityManager().createNativeQuery(sqlString);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static Query createNamedQuery(String name) throws DatabaseException {
		try {
			return getEntityManager().createNamedQuery(name);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}

	public static CriteriaBuilder getCriteriaBuilder() throws DatabaseException {
		try {
			return getEntityManager().getCriteriaBuilder();
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
	}
}