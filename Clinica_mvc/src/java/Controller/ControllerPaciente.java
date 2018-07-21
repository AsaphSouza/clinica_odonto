package Controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.PacienteModel;
import model.entidades.Endereco;
import model.entidades.Paciente;

@ManagedBean
@SessionScoped
public class ControllerPaciente {

    private PacienteModel pacienteModel; 
    private Paciente paciente;
    private String cpf;
    private Endereco endereco;

    public ControllerPaciente() {
    	pacienteModel = new PacienteModel();
    	paciente  = new Paciente();
    	endereco = new Endereco();
    }
    
	public void cadastrarPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.inserirPaciente(paciente);
//            context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }
    
    public void deletarPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.deletarPaciente(paciente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } 
    }
    
    public void atualizarPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pacienteModel.atualizarPaciente(paciente);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        } 
    }
    
    public Paciente buscarPacienteCPF () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return pacienteModel.buscarpPorCPF(cpf);
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return  null;
        }
    }
    
    public List<Paciente> buscarPorCidades () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return pacienteModel.buscarPcidade(endereco.getCidade());
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
    
    public List<Paciente> buscarPorEstado () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return pacienteModel.buscarPestado(endereco.getEstado());
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
    
    public List<Paciente> buscarTodos () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           return  pacienteModel.listarPacientes();
        } catch (Exception e){
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }
    }
    
    public PacienteModel getPacienteModel() {
        return pacienteModel;
    }

    public void setPacienteModel(PacienteModel pacienteModel) {
        this.pacienteModel = pacienteModel;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
