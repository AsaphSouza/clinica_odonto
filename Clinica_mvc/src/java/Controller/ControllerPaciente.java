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
    private Paciente paciente;

    public ControllerPaciente(Paciente paciente, PacienteModel pacienteModel, 
            EntityManager entityManager) {
        this.paciente = new Paciente();
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
    
    public void atualizarPaciente(Paciente paciente) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.atualizarPaciente(paciente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } finally {
            entityManager.close();
        }
    }
    
    public Paciente buscarPacienteCPF (String cpf) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           paciente = pacienteModel.buscarpPorCPF(cpf);
        } catch (HibernateException ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
            paciente = null;
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            paciente = null;
        } finally {
            entityManager.close();
        }
        return paciente;
    }
    
    public List<Paciente> buscarPorCidades (String cidade) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           this.listaPaciente = null;
           this.listaPaciente = pacienteModel.buscarPcidade(cidade);
        } catch (HibernateException ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } finally {
            entityManager.close();
        }
        return listaPaciente;
    }
    
    public List<Paciente> buscarPorEstado (String estado) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           this.listaPaciente = null;
           this.listaPaciente = pacienteModel.buscarPestado(estado);
        } catch (HibernateException ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } finally {
            entityManager.close();
        }
        return listaPaciente;
    }
    
    public List<Paciente> buscarTodos () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           this.listaPaciente = null;
           this.listaPaciente = pacienteModel.listarPacientes();
        } catch (HibernateException ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
        } finally {
            entityManager.close();
        }
        return listaPaciente;
    }
}
