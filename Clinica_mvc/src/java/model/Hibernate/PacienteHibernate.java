package model.Hibernate;

import java.security.InvalidParameterException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.PacienteDao;
import model.entidades.Paciente;
import org.hibernate.HibernateException;

public class PacienteHibernate implements PacienteDao {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Paciente paciente) {
        try {
            em.getTransaction().begin();
            em.persist(paciente);
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
    public void atualizar(Paciente paciente) {
        try {
            em.getTransaction().begin();
            em.merge(paciente);
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
    public void deletar(Paciente paciente) {
        try {
            em.getTransaction().begin();
            em.remove(paciente);
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
    public Paciente buscarPeloCPF(String cpf) {
        Paciente paciente = null;
        String jpql = "from Paciente where cpf = :cpf";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("cpf", cpf);
            paciente = (Paciente)query.getSingleResult();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }  finally {
            em.close();
        }
        return paciente;
    }

    @Override
    public long buscarPeloID(long id) {
        return 1l;
    }

    @Override
    public List<Paciente> buscarPorCidade(String cidade) {
        return null;
    }

    @Override
    public List<Paciente> buscarPorEstado(String estado) {
       return null;
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }

}
