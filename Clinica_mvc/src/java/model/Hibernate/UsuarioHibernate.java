package model.Hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.dao.UsuarioDAO;
import model.entidades.Usuario;
import org.hibernate.HibernateException;

public class UsuarioHibernate implements UsuarioDAO {

    private final EntityManager em = Persistencia.getEntityManager();

    @Override
    public void inserir(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
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
    public void atualizar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.merge(usuario);
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
    public void deletar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(usuario);
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
        return 1l;
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios;
        TypedQuery<Usuario> query;
        try {
            query = em.createQuery("from Usuario", Usuario.class);
            usuarios = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return usuarios;
    }

    @Override
    public List<Usuario> listarPorTipo(String tipo) {
        List<Usuario> usuarios;
        TypedQuery<Usuario> query;
        try {
            query = em.createQuery("from Usuario where tipoususario = :tipo", Usuario.class);
            query.setParameter("tipo", tipo);
            usuarios = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return usuarios;
    }

    @Override
    public Usuario buscarPorUser(String user) {
        TypedQuery<Usuario> query;
        try {
            query = em.createQuery("from Usuario where userUsuario = :user", Usuario.class);
            query.setParameter("user", user);
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }
}
