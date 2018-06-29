package model.Hibernate;

import java.util.Date;
import javax.persistence.EntityManager;
import model.dao.ConsultaDao;
import model.entidades.Consulta;
import org.hibernate.HibernateException;

public class ConsultaHibernate implements ConsultaDao {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Consulta consulta) {
        try {
            em.getTransaction().begin();
            em.persist(consulta);
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
    public void atualizar(Consulta consulta) {
        try {
            em.getTransaction().begin();
            em.merge(consulta);
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
    public void deletar(Consulta consulta) {
        try {
            em.getTransaction().begin();
            em.remove(consulta);
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
    public Consulta buscarPorDia(Date data) {
        return null;
    }

    @Override
    public Consulta buscarPorPeriodo(Date dataInicial, Date dataFinal) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
