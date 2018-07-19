package model.Hibernate;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import model.dao.EnderecoDAO;
import model.entidades.Endereco;

public class EnderecoHibernate implements EnderecoDAO{
	private final EntityManager em = Persistencia.getEntityManager();
	
    public void inserir(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.persist(endereco);
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
    public void atualizar(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.merge(endereco);
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
    public void deletar(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.remove(endereco);
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
	public long buscarPeloID(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
