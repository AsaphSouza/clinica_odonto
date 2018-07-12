package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import model.AssistenteModel;
import model.entidades.Assistente;
import org.hibernate.HibernateException;

public class ControllerAssistente {
    private AssistenteModel assistenteModel;
    private Assistente assistente;
    private final EntityManager ENTITY_MANAGER;
    
    public ControllerAssistente (EntityManager entityManager) {
        this.ENTITY_MANAGER = entityManager; 
    }
    
    public void cadastrarAssitente (Assistente assistente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.inserirAssistente(assistente);
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (HibernateException e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            ENTITY_MANAGER.close();
        }
    }
    
    public void deletarAssistente (Assistente assistente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.deletarAssistente(assistente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            ENTITY_MANAGER.close();
        }
    }
    
    public void atualizarAssistente (Assistente assistente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.atualizarAssistente(assistente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            ENTITY_MANAGER.close();
        }
    }
    
    public Assistente buscarPorNome (String nome) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistente = assistenteModel.buscarAssistente(nome);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            assistente = null;
        } finally {
            ENTITY_MANAGER.close();
        }
        return assistente;
    }
}
