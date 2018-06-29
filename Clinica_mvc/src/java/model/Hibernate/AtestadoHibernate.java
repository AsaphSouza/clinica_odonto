package model.Hibernate;

import javax.persistence.EntityManager;
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
    public Atestado buscarPorTipo(String tipo) {
       return null; 
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
