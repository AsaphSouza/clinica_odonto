package model.Hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.entidades.Pergunta;
import model.dao.QuestionarioDAO;
import model.entidades.Questionario;
import org.hibernate.HibernateException;

public class QuestionarioHibernate implements QuestionarioDAO{
    
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Questionario questionario) {
        try {
            em.getTransaction().begin();
            em.persist(questionario);
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
    public void atualizar(Questionario questionario) {
        try {
            em.getTransaction().begin();
            em.merge(questionario);
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
    public void deletar(Questionario questionario) {
        try {
            em.getTransaction().begin();
            em.remove(questionario);
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
    public List<Pergunta> buscarPorNome(String nome) {
    	TypedQuery<Pergunta> query;
        try {
            query = em.createQuery("select * from Questionario as q join Pergunta as p where q.idquestionario = :p.idquestionario"
            		+ "and q.nome = :nome",Pergunta.class);
            query.setParameter("nome", nome);
            return  query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
