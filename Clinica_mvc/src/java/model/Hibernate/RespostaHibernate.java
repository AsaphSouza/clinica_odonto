package model.Hibernate;

import javax.persistence.EntityManager;
import model.dao.RespostaDAO;
import model.entidades.Resposta;
import org.hibernate.HibernateException;

public class RespostaHibernate implements RespostaDAO {
    
    
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Resposta resposta) {
        try {
            em.getTransaction().begin();
            em.persist(resposta);
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
    public void atualizar(Resposta resposta) {
        try {
            em.getTransaction().begin();
            em.merge(resposta);
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
    public void deletar(Resposta resposta) {
        try {
            em.getTransaction().begin();
            em.remove(resposta);
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
    public Resposta buscarPorIDpergunta(long idPergunta) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
}
