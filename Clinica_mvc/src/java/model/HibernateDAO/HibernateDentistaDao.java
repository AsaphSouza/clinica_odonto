package model.HibernateDAO;

import javax.persistence.EntityManager;
import model.dao.DentistaDao;
import model.entidades.Dentista;

public class HibernateDentistaDao implements DentistaDao {
    private final EntityManager em = Persistencia.getEntityManager();
    
    @Override
    public void inserir(Dentista dentista) {
        try {
            em.getTransaction().begin();
            em.persist(dentista);
            em.getTransaction().commit();
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

    @Override
    public Dentista pegar(Dentista obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dentista procurarPelocro(int cro) {
        // TODO Auto-generated method stub
        return null;
    }

}
