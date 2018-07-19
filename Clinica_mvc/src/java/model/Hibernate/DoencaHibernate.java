package model.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.dao.DoencaDAO;
import model.entidades.Doenca;
import org.hibernate.HibernateException;

public class DoencaHibernate implements DoencaDAO {
	private final EntityManager em = Persistencia.getEntityManager();

	@Override
	public void inserir(Doenca doenca) {
		try {
			em.getTransaction().begin();
			em.persist(doenca);
			em.getTransaction().commit();

		} catch (HibernateException e) {
			em.getTransaction().rollback();

		} catch (Exception e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	@Override
	public void atualizar(Doenca doenca) {
		try {
			em.getTransaction().begin();
			em.merge(doenca);
			em.getTransaction().commit();

		} catch (HibernateException e) {
			em.getTransaction().rollback();

		} catch (Exception e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	@Override
	public void deletar(Doenca doenca) {
		try {
			em.getTransaction().begin();
			em.remove(doenca);
			em.getTransaction().commit();

		} catch (HibernateException e) {
			em.getTransaction().rollback();

		} catch (Exception e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	@Override
	public Doenca buscarPorNome(String nome) {
		TypedQuery<Doenca> query;
		try {
			query = em.createQuery("from Doenca where nome = :nome", Doenca.class);
			query.setParameter("nome", nome);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public long buscarPeloID(long id) {
		return 1l;
	}
}
