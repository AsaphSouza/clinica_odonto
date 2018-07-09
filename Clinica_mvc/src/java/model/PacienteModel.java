package model;

import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.List;
import model.Hibernate.PacienteHibernate;
import model.dao.PacienteDao;
import org.hibernate.HibernateException;

public class PacienteModel {

    private List<Paciente> lista;
    private final PacienteDao pacienteDao;
    private CPF cpf;

    
    public void marcarConsulta() {// as requisi��es que ir�o serem feitas no sistema deve ficar no "model"
        // aqui marcará a consulta
    }

    public void marcarExame() {
        // aqui marcará o exame
    }

    public void cancelarEC() {
        // aqui cancela os exames ou consultas
    }
    
    //rever
    public List<Paciente> listarPacientes () {
        return pacienteDao.listarTodos();
    }

    public PacienteModel() {
        this.pacienteDao = new PacienteHibernate();
        
    }

    public void inserirPaciente(Paciente paciente) {
        try {
           if (cpf.validarCpf(paciente.getCpf()) == false) {
            throw new InvalidParameterException("CPF não é válido.");
        } else {
            if (pacienteDao.buscarPeloCPF(paciente.getCpf()) == null) {
                pacienteDao.inserir(paciente);
            } else {
                throw new InvalidParameterException("Paciente já cadastrado na base de dados.");
            }
        } 
        } catch (HibernateException e) {
            throw new InvalidParameterException("Erro na Base de Dados.");
        }
    }

    public void atualizarPaciente(Paciente paciente) {
        try {
            pacienteDao.atualizar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao atualizar os dados do paciente.");
        }
       
    }

    public void deletarPaciente(Paciente paciente) {
        try {
            pacienteDao.deletar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao deletar paciente.");
        }
    }

    public Paciente buscarpPorCPF(String cpf) {
        try {
           return pacienteDao.buscarPeloCPF(cpf); 
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }     
    }
    
    public Paciente buscarPorID (Paciente paciente) {
        pacienteDao.buscarPeloID(paciente.getId());
        return null;
    }

}
