package model.Hibernate;

import java.util.Date;
import javax.persistence.EntityManager;
import model.dao.ExameDAO;
import model.entidades.Exame;
import org.hibernate.HibernateException;

public class ExameHibernate implements ExameDAO{
        private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Exame exame) {
        try {
            em.getTransaction().begin();
            em.persist(exame);
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
    public void atualizar(Exame exame) {
        try {
            em.getTransaction().begin();
            em.merge(exame);
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
    public void deletar(Exame exame) {
        try {
            em.getTransaction().begin();
            em.remove(exame);
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
    public Exame buscarPorNome(String nome) {
        return null;
    }

    @Override
    public Exame buscarPorIDconsulta(long idConsulta) {
        return null;
    }

    @Override
    public Exame buscarPorIDpaciente(long idPaciente) {
        return null;
    }

    @Override
    public Exame buscarPorDia(Date data) {
        return null;
    }

    @Override
    public Exame buscarPorPeriodo(Date dataInicial, Date dataFinal) {
        return null;
    }

    public long buscarPeloID(long id) {
        return 1l;
    }
}
