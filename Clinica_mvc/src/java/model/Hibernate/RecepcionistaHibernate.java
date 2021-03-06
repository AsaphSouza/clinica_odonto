package model.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.dao.RecepcionistaDao;
import model.entidades.Recepcionista;
import org.hibernate.HibernateException;

public class RecepcionistaHibernate implements RecepcionistaDao {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Recepcionista recepcionista) {
        try {
            em.getTransaction().begin();
            em.persist(recepcionista);
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
    public void atualizar(Recepcionista recepcionista) {
        try {
            em.getTransaction().begin();
            em.merge(recepcionista);
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
    public void deletar(Recepcionista recepcionista) {
        try {
            em.getTransaction().begin();
            em.remove(recepcionista);
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
    public Recepcionista BuscarPorNome(String nome) {
        try {
            TypedQuery<Recepcionista> query = this.em.createQuery("from Recepcionista where nome = :nome",Recepcionista.class);
            query.setParameter("nome", nome);
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
