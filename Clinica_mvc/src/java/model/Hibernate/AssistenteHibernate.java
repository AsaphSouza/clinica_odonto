package model.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.dao.AssistenteDAO;
import model.entidades.Assistente;
import org.hibernate.HibernateException;

public class AssistenteHibernate implements AssistenteDAO{
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Assistente assistente) {
        try {
            em.getTransaction().begin();
            em.persist(assistente);
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
    public void atualizar(Assistente assistente) {
        try {
            em.getTransaction().begin();
            em.merge(assistente);
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
    public void deletar(Assistente assistente) {
        try {
            em.getTransaction().begin();
            em.remove(assistente);
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
    public Assistente buscarPorNome(String nome) {
        TypedQuery<Assistente> query; 
        try {
        	query = em.createQuery("from Assistente where nome = :nome",Assistente.class);
            query.setParameter("nome", nome);
            return  query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
    
}
