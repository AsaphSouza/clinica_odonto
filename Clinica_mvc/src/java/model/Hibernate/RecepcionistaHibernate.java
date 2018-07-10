package model.Hibernate;

import java.security.InvalidParameterException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Recepcionista recepcionista = null;
        String jpql = "from Recepcionista where nome = :nome";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("nome", nome);
            recepcionista = (Recepcionista)query.getSingleResult();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo recepcionista.");
        }  finally {
            em.close();
        }
        return recepcionista;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
