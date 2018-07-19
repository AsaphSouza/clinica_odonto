package model.Hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public List<Consulta> buscarPorDia(Date data) {
    	TypedQuery<Consulta> query;
        try {
            query = em.createQuery("from Consulta where data = :data",Consulta.class);
            query.setParameter("data", data);
            return  query.getResultList();
            
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Consulta> buscarPorPeriodo(Date dataInicial, Date dataFinal) {
    	TypedQuery<Consulta>query;
        try {
            query = em.createQuery("from Dentista where data between (:dataInicial, :dataFinal)",Consulta.class);
            query.setParameter("dataInicial", dataInicial);
            query.setParameter("dataFinal", dataFinal);
            return query.getResultList();
            
        } catch(NoResultException e){
            return null;
        }

    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

    @Override
    public List<Consulta> buscarPorMes(Date data) {
        TypedQuery<Consulta> query;
        try {
        	GregorianCalendar calendar = new GregorianCalendar();
        	calendar.setTime(data);
        	int mes = calendar.get(Calendar.MONTH);
            query = em.createQuery("from Dentista where MONTH(data) = : mes",Consulta.class);
            query.setParameter("mes", mes);
            return query.getResultList();
            
        } catch(NoResultException e){
        	return null;
        }
    }

}
