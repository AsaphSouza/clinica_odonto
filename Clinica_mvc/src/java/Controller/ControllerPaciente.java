package Controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import model.PacienteModel;
import model.entidades.Paciente;
import org.hibernate.HibernateException;

@ManagedBean
@SessionScoped
public class ControllerPaciente {

    PacienteModel pacienteModel;
    private final EntityManager entityManager;
    private List<Paciente> listaPaciente;

    public ControllerPaciente(PacienteModel pacienteModel, EntityManager entityManager) {
        this.pacienteModel = pacienteModel;
        this.entityManager = entityManager;
    }

    public void cadastrarPaciente(Paciente paciente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.inserirPaciente(paciente);
            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (HibernateException e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            entityManager.close();
        }

    }
    
    public void deletarPaciente(Paciente paciente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.deletarPaciente(paciente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            entityManager.close();
        }
    }
}
