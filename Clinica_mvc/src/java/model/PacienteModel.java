package model;

import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.Hibernate.PacienteHibernate;
import model.dao.PacienteDao;
import org.hibernate.HibernateException;

public class PacienteModel {

    private PacienteDao pacienteDao;
    private CPF cpf;

    public void marcarConsulta() {

    }

    public void marcarExame() {

    }

    public void cancelarEC() {
    }

    public List<Paciente> listarPacientes() {
        try {
            return pacienteDao.listarTodos();
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao listar pacientes.");
        }
    }

    public PacienteModel() {
        this.pacienteDao = new PacienteHibernate();
        this.cpf = new CPF();

    }

    public void inserirPaciente(Paciente paciente) {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (cpf.validarCpf(paciente.getCpf()) == false) {
                context.addMessage(null, new FacesMessage("CPF não é válido."));
            } else {
                if (pacienteDao.buscarPeloCPF(paciente.getCpf()) == null) {
                    pacienteDao.inserir(paciente);
                } else {
                    context.addMessage(null, new FacesMessage("Paciente já cadastrado na base de dados."));
                }
            }
        } catch (HibernateException e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
        }
    }

    public void atualizarPaciente(Paciente paciente) throws Exception {
        try {
            pacienteDao.atualizar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao atualizar os dados do paciente.");
        }

    }

    public void deletarPaciente(Paciente paciente) throws Exception {
        try {
            pacienteDao.deletar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao deletar paciente.");
        }
    }

    public Paciente buscarpPorCPF(String cpf) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return pacienteDao.buscarPeloCPF(cpf);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Falha ao procurar pelo cpf"));
            return null;
        }
    }

    // não está sendo usado
    public Paciente buscarPorID(Paciente paciente) {
        pacienteDao.buscarPeloID(paciente.getId());
        return null;
    }

    public List<Paciente> buscarPcidade(String cidade) throws InvalidParameterException {
        try {
            return pacienteDao.buscarPorCidade(cidade);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }
    }

    public List<Paciente> buscarPestado(String estado) throws InvalidParameterException {
        try {
            return pacienteDao.buscarPorEstado(estado);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }
    }
}
