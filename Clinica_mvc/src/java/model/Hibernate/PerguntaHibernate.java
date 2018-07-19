package model.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.dao.PerguntaDAO;
import model.entidades.Pergunta;
import org.hibernate.HibernateException;

public class PerguntaHibernate implements PerguntaDAO{
    
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Pergunta pergunta) {
        try {
            em.getTransaction().begin();
            em.persist(pergunta);
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
    public void atualizar(Pergunta pergunta) {
        try {
            em.getTransaction().begin();
            em.merge(pergunta);
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
    public void deletar(Pergunta pergunta) {
        try {
            em.getTransaction().begin();
            em.remove(pergunta);
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
    public List<Pergunta> buscarPorTipo(String tipo) {
    	TypedQuery<Pergunta> query;
        try {
            query = em.createQuery("from Pergunta where tipo = :tipo",Pergunta.class);
            query.setParameter("tipo", tipo);
            return  query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public Pergunta buscarPorIDquestionario(long idQuestionario) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
}
