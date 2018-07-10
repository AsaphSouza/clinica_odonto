package model.Hibernate;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        List<Consulta> consultas = null;
        String jpql = "from Consulta where data = :data";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("data", data);
            consultas = (List<Consulta>)query.getResultList();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }  finally {
            em.close();
        }
        return consultas;
    }

    @Override
    public List<Consulta> buscarPorPeriodo(Date dataInicial, Date dataFinal) {
        List<Consulta>consultas = null;
        String jpql = "from Dentista where data between (:dataInicial, :dataFinal)";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("dataInicial", dataInicial);
            query.setParameter("dataFinal", dataFinal);
            consultas = (List<Consulta>) query.getResultList();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar consultas por período.");
        }  finally {
            em.close();
        }
        return consultas;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

    @Override
    public List<Consulta> buscarPorMes(Date data) {
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.setTime(data);
//        int mes = calendar.get(Calendar.MONTH);
//        
//        List<Consulta>consultas = null;
//        String jpql = "from Dentista where data between (:dataInicial, :dataFinal)";
//        try {
//            Query query = this.em.createQuery(jpql);
//            query.setParameter("dataInicial", dataInicial);
//            query.setParameter("dataFinal", dataFinal);
//            consultas = (List<Consulta>) query.getResultList();
//            
//        } catch(HibernateException e){
//            throw new InvalidParameterException("Erro ao buscar consultas por período.");
//        }  finally {
//            em.close();
//        }
//        return consultas;
          return null;
    }


}
