package Controller;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.dao.PacienteDao;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class ControllerLogin {

    Paciente paciente;
    private PacienteDao pd ;


    public ControllerLogin() {

    }

    public void logarr() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (paciente.getCpf().equals("666.666.666-66") && paciente.getNome().equals("bil")) {

            context.getExternalContext().getSessionMap().put("user", paciente.getCpf());
            context.getExternalContext().getSessionMap().put("perfil", "usuario");
            context.getExternalContext().getSessionMap().put("erroLogin", "nao");
            try {
                context.getExternalContext().redirect("sair.xhtml");

            } catch (IOException e) {

            }
        } else {
            context.getExternalContext().getSessionMap().put("erroLogin", "sim");
            context.addMessage(null, new FacesMessage("A autenticação falhou!!!"));
        }

    }
    
    public String logar() {
        String ret = "";
        FacesContext context = FacesContext.getCurrentInstance();
        
       // Paciente paciente = pd.procurarPeloidPaciente(this.paciente.getId());
        if (this.paciente.getCpf().equals("666.666.666-66") && paciente.getNome().equals("bil")) {

            context.getExternalContext().getSessionMap().put("adm", this.paciente.getCpf());
            ret = "Administrador.xhtml";
            //context.getExternalContext().getSessionMap().put("perfil", "adm");
            //context.getExternalContext().getSessionMap().put("erroLogin", "nao");

            //context.getExternalContext().redirect("PaginaAdmin.xhtml");
        } else if (paciente != null && paciente.getCpf().equals(this.paciente.getCpf())){
            context.getExternalContext().getSessionMap().put("user", this.paciente.getCpf());
            ret = "sair.xhtml";
        } else {
            context.addMessage(null, new FacesMessage("A autenticação falhou!!!"));
        }
        return ret;
    }

    public void sair() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();

        try {
            context.getExternalContext().redirect("logar.xhtml");
        } catch (IOException e) {

        }
    }

    public boolean checarErro() {
        boolean temErro = false;

        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getExternalContext().getSessionMap().get("erroLogin") != null) {
            if (context.getExternalContext().getSessionMap().get("erroLogin").toString().equals("sim")) {
                temErro = true;
                context.getExternalContext().getSessionMap().put("erroLogin", "nao");
            }
        }
        return temErro;
    }
}
