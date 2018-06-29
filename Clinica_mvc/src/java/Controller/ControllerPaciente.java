package Controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import model.PacienteModel;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class ControllerPaciente {

    Paciente paciente;
    PacienteModel pacienteModel;
    private final EntityManager entityManager;
    private List<Paciente> listaPaciente;

    public ControllerPaciente(PacienteModel pacienteModel, EntityManager entityManager) {
        this.pacienteModel = pacienteModel;
        this.entityManager = entityManager;
    }

    public void cadastrarPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.inserirPaciente(paciente);
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
            
            // listaTodos();
            paciente = new Paciente();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            entityManager.close();
        }

    }
    
    public void deletarFuncionario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.deletarPaciente(paciente);
            //listaTodos();
            paciente = new Paciente();
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }

    }

}
