package Controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class ControllerAdministrador {
    
    Paciente paciente;
    
    public void paginaLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("logar.xhtml");
        } catch (IOException e) {

        }
    }

    public void paginaCadastroAssistente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastroAssistente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaDentista() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastroDentista.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaCadastroPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastroPaciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaRecepcionista() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("CadastroRecepcionista.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaConsultasPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("ConsultasPaciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaReceitaseAtestados() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("ConsultasPaciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void paginaExames() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Exames.xhtml");
        } catch (IOException e) {

        }
    }
}
