
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
    
    public void checkUsuarioSession() throws IOException{
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPaciente") != null){
            int idPaciente = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPaciente").toString());
            if(paciente == null)
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Paciente/");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Paciente/");
        }
    }
    
    
    public void PaginaLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("logar.xhtml");
        } catch (IOException e) {

        }
    }

    public void PaginaAssistente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Assistente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaDentista() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Medico.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Paciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaRecepcionista() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Recepcionista.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaConsultasPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("ConsultasPaciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaReceitaseAtestados() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("ConsultasPaciente.xhtml");
        } catch (IOException e) {

        }
    }
    
    public void PaginaExames() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("Exames.xhtml");
        } catch (IOException e) {

        }
    }
}
