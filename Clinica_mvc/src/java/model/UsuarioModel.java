package model;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.UsuarioHibernate;
import model.dao.UsuarioDAO;
import model.entidades.Usuario;

public class UsuarioModel {

    private UsuarioDAO usuarioDao;

    public UsuarioModel() {
        usuarioDao = new UsuarioHibernate();
    }

    public void inserir(Usuario usuario) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (usuarioDao.buscarPorUser(usuario.getUser()) == null) {
                usuarioDao.inserir(usuario);
                context.addMessage(null, new FacesMessage("Usuario Cadastrado."));
            } else {
                context.addMessage(null, new FacesMessage("Usuario já cadastrado na base de dados."));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
        }

    }

    public void atualizar(Usuario usuario) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioDao.atualizar(usuario);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
        }

    }

    public void deletar(Usuario usuario) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioDao.deletar(usuario);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
        }
    }

    public List<Usuario> listarTodos() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return usuarioDao.listarTodos();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
            return null;
        }

    }

    public List<Usuario> listarPorTipo(String tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return usuarioDao.listarPorTipo(tipo);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
            return null;
        }
    }

    public Usuario buscarPorUser(String user) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return usuarioDao.buscarPorUser(user);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
            return null;
        }
    }
}
