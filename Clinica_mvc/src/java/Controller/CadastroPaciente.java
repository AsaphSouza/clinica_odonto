package Controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class CadastroPaciente {

    Paciente paciente;

    public CadastroPaciente() {

    }

    public void cadastrar() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("Cadastros.xhtml");

    }
}
