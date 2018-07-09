package model.Hibernate;

import java.security.InvalidParameterException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.DentistaDao;
import model.entidades.Dentista;
import org.hibernate.HibernateException;

public class DentistaHibernate implements DentistaDao {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.persist(dentista);
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
    public void atualizar(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.merge(dentista);
            em.getTransaction().commit();
            
        } catch(HibernateException e) {
            em.getTransaction().rollback();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        } finally {
            em.close();
        }
    }

    @Override
    public void deletar(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.remove(dentista);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
//    public Dentista buscarPeloId (Long id) {
//        Dentista dentista = em.find(Dentista.class, Long.valueOf(id));
//        return dentista;
//    }

    @Override
    public Dentista BuscarPeloCRO(String cro) {
        Dentista dentista = null;
        String jpql = "from Dentista where cro = :cro";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("cro", cro);
            dentista = (Dentista)query.getSingleResult();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo CRO.");
        }  finally {
            em.close();
        }
        return dentista;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

}
