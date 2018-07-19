package model.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.dao.AtestadoDAO;
import model.entidades.Atestado;
import org.hibernate.HibernateException;

public class AtestadoHibernate implements AtestadoDAO{
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.persist(atestado);
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
    public void atualizar(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.merge(atestado);
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
    public void deletar(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.remove(atestado);
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
    public List<Atestado> buscarPorTipo(String tipo) {
    	TypedQuery<Atestado>query;
        try {
        	query = em.createQuery("from Atestado where tipo = :tipo",Atestado.class);
            query.setParameter("tipo", tipo);
            return  query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public Atestado buscarPorIDconsulta(int idConsulta) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
}
