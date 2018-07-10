package model.Hibernate;

import java.security.InvalidParameterException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.AtestadoDAO;
import model.entidades.Atestado;
import org.hibernate.HibernateException;

public class AtestadoHibernate implements AtestadoDAO{
    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.persist(atestado);
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
    public void atualizar(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.merge(atestado);
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
    public void deletar(Atestado atestado) {
        try {
            em.getTransaction().begin();
            em.remove(atestado);
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
    public Atestado buscarPorTipo(String tipo) {
        Atestado atestado = null;
        String jpql = "from Atestado where tipo = :tipo";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("tipo", tipo);
            atestado = (Atestado)query.getSingleResult();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo atestado.");
        }  finally {
            em.close();
        }
        return atestado;
    }

    @Override
    public Atestado buscarPorIDconsulta(int idConsulta) {
        return null;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }
}
