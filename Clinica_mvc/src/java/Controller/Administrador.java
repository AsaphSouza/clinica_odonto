package Controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class Administrador {
    
    Paciente paciente;
    
    public void checkUsuarioSession() throws IOException{
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPaciente") != null){
            int sessionUsuarioID = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idPaciente").toString());
            if(paciente == null)
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Paciente/");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Paciente/");
        }
    }
    
    
    public void PaginaLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {

        }
    }

    public void PaginaCadastro() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("cadastros.xhtml");
        } catch (IOException e) {

        }
    }
    
}
