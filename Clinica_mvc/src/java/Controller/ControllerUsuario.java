package Controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.UsuarioModel;
import model.entidades.Usuario;

public class ControllerUsuario {

    private UsuarioModel usuarioModel;
    private Usuario usuario;
    
    public void cadastrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioModel.inserir(usuario);
//            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }

    public void deletar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioModel.deletar(usuario);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void atualizar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioModel.atualizar(usuario);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public Usuario buscarPorUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return usuarioModel.buscarPorUser(usuario.getUser());
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
    
    public List<Usuario> listarPorTipo () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return usuarioModel.listarPorTipo(usuario.getTipoDeUsuario());
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
    
    public List<Usuario> listarTodos () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return usuarioModel.listarTodos();
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
}
