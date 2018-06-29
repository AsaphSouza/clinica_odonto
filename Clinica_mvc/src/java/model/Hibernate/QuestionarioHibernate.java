package model.Hibernate;

import javax.persistence.EntityManager;
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
    public Questionario buscarPorNome(String nome) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
