package model.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.dao.DentistaDao;
import model.entidades.Dentista;
import org.hibernate.HibernateException;

public class DentistaHibernate implements DentistaDao {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.persist(dentista);
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
    public void atualizar(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.merge(dentista);
            em.getTransaction().commit();
            
        } catch(HibernateException e) {
            em.getTransaction().rollback();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        } finally {
            em.close();
        }
    }

    @Override
    public void deletar(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.remove(dentista);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Dentista BuscarPeloCRO(String cro) {
    	TypedQuery<Dentista> query;
        try {
            query = em.createQuery("from Dentista where cro = :cro",Dentista.class);
            query.setParameter("cro", cro);
            return query.getSingleResult();
            
        } catch(NoResultException e){
        	return null;
        }
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
