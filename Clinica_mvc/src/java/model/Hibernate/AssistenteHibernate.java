package model.Hibernate;

import java.security.InvalidParameterException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Assistente assistente = null;
        String jpql = "from Assistente where nome = :nome";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("nome", nome);
            assistente = (Assistente)query.getSingleResult();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo assistente.");
        }  finally {
            em.close();
        }
        return assistente;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
    
}
