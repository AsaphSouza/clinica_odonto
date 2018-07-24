package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.AssistenteModel;
import model.entidades.Assistente;
import org.hibernate.HibernateException;

@ManagedBean
@SessionScoped
public class ControllerAssistente {

    private AssistenteModel assistenteModel;
    private Assistente assistente;
    private String nome;

    public ControllerAssistente() {
        assistenteModel = new AssistenteModel();
        assistente = new Assistente();
    }

    public void cadastrarAssitente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.inserirAssistente(assistente);
            //context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (HibernateException e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void deletarAssistente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.deletarAssistente(assistente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void atualizarAssistente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteModel.atualizarAssistente(assistente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public Assistente buscarPorNome() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return assistenteModel.buscarAssistente(nome);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }

    public AssistenteModel getAssistenteModel() {
        return assistenteModel;
    }

    public void setAssistenteModel(AssistenteModel assistenteModel) {
        this.assistenteModel = assistenteModel;
    }

    public Assistente getAssistente() {
        return assistente;
    }

    public void setAssistente(Assistente assistente) {
        this.assistente = assistente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
