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
        List <Paciente> pacientes = null;
        String jpql = "from Paciente where cidade = :cidade";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("cidade", cidade);
            pacientes = (List<Paciente>)query.getResultList();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao listar pacientes.");
        }  finally {
            em.close();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> buscarPorEstado(String estado) {
       List <Paciente> pacientes = null;
        String jpql = "from Paciente where cidade = :estado";
        try {
            Query query = this.em.createQuery(jpql);
            query.setParameter("estado", estado);
            pacientes = (List<Paciente>)query.getResultList();
            
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao listar pacientes.");
        }  finally {
            em.close();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> listarTodos() {
        List <Paciente> pacientes = null;
        String jpql = "from Paciente";
        try {
            Query query = this.em.createQuery(jpql);
            pacientes = (List<Paciente>)query.getResultList();
        } catch(HibernateException e){
            throw new InvalidParameterException("Erro ao listar pacientes.");
        }  finally {
            em.close();
        }
        return pacientes;
    }

}
