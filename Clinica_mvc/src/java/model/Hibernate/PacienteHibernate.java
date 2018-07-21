package model.Hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
    	TypedQuery<Paciente> paciente;
        try {
        paciente = em.createQuery("from Paciente where cpf = :cpf",Paciente.class);
        paciente.setParameter("cpf", cpf);       
        return paciente.getSingleResult();    
        } catch(NoResultException e){
            return null;
        } 
    }

	@Override
    public long buscarPeloID(long id) {
        return 1l;
    }

    @Override
    public List<Paciente> buscarPorCidade(String cidade) {
        List <Paciente> pacientes = new ArrayList<>();
        String jpql = "from Paciente where cidade = :cidade";
        try {
            TypedQuery<Paciente> query = em.createQuery(jpql,Paciente.class);
            query.setParameter("cidade", cidade);
            pacientes =  query.getResultList();         
        } catch(NoResultException e){
            return null;
        } 
        return pacientes;
    }

    @Override
    public List<Paciente> buscarPorEstado(String estado) {
       List <Paciente> pacientes = new ArrayList<>();
        String jpql = "from Paciente where estado = :estado";
        try {
            TypedQuery<Paciente> query = em.createQuery(jpql,Paciente.class);
            query.setParameter("estado", estado);
            pacientes = query.getResultList();
            
        } catch(NoResultException e){
            return null;
        } 
        return pacientes;
    }

    @Override
    public List<Paciente> listarTodos() {
        List <Paciente> pacientes = new ArrayList<>();
        String jpql = "from Paciente";
        try {
            TypedQuery<Paciente> query = em.createQuery(jpql,Paciente.class);
            pacientes = query.getResultList();
        } catch(NoResultException e){
            return null;
        }
        return pacientes;
    }
}