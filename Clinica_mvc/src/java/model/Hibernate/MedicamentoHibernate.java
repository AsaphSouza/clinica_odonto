package model.Hibernate;

import javax.persistence.EntityManager;
import model.dao.MedicamentoDAO;
import model.entidades.Medicamento;
import org.hibernate.HibernateException;

public class MedicamentoHibernate implements MedicamentoDAO{
    
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Medicamento medicamento) {
        try {
            em.getTransaction().begin();
            em.persist(medicamento);
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
    public void atualizar(Medicamento medicamento) {
        try {
            em.getTransaction().begin();
            em.merge(medicamento);
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
    public void deletar(Medicamento medicamento) {
        try {
            em.getTransaction().begin();
            em.remove(medicamento);
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
    public Medicamento buscarPorNome(String nome) {
        return null;
    }

    public long buscarPeloID(long id) {
        return 1l;
    }
}
