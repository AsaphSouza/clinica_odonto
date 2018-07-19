package model.Hibernate;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    	TypedQuery<Exame> query;
        try {
            query = em.createQuery("from Exame where nome = :nome",Exame.class);
            query.setParameter("nome", nome);
            return  query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Exame> buscarPorDia(Date data) {
    	TypedQuery<Exame> exames;
        try {
        	exames = em.createQuery("from Exame where data = :data",Exame.class);
            exames.setParameter("data", data);
            return  exames.getResultList();
            
            
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Exame> buscarPorPeriodo(Date dataInicial, Date dataFinal) {
    	TypedQuery<Exame>query;
        try {
            query = em.createQuery("from Exame where data between (:dataInicial, :dataFinal)",Exame.class);
            query.setParameter("dataInicial", dataInicial);
            query.setParameter("dataFinal", dataFinal);
            return query.getResultList();
            
        } catch(NoResultException e){
            return null;
        }
    }

    public long buscarPeloID(long id) {
        return 1l;
    }

	@Override
	public List<Exame> buscarPorIDconsulta(long idConsulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exame> buscarPorIDpaciente(long idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
