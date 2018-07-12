package model;

import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.List;
import model.Hibernate.PacienteHibernate;
import model.dao.PacienteDao;
import org.hibernate.HibernateException;

public class PacienteModel {

    private List<Paciente> lista;
    private final PacienteDao PACIENTE_DAO;
    private CPF cpf;

    
    public void marcarConsulta() {
        
    }

    public void marcarExame() {
        
    }

    public void cancelarEC() {
    }
    
    public List<Paciente> listarPacientes () {
        try {
            lista = null;
            this.lista = PACIENTE_DAO.listarTodos();
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao listar pacientes.");
        }
        return lista;
    }

    public PacienteModel() {
        this.PACIENTE_DAO = new PacienteHibernate();
        
    }

    public void inserirPaciente(Paciente paciente) {
        try {
           if (cpf.validarCpf(paciente.getCpf()) == false) {
            throw new InvalidParameterException("CPF não é válido.");
        } else {
            if (PACIENTE_DAO.buscarPeloCPF(paciente.getCpf()) == null) {
                PACIENTE_DAO.inserir(paciente);
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
            PACIENTE_DAO.atualizar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao atualizar os dados do paciente.");
        }
       
    }

    public void deletarPaciente(Paciente paciente) {
        try {
            PACIENTE_DAO.deletar(paciente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao deletar paciente.");
        }
    }

    public Paciente buscarpPorCPF(String cpf) {
        try {
           return PACIENTE_DAO.buscarPeloCPF(cpf); 
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }     
    }
    
    //não está sendo usado
    public Paciente buscarPorID (Paciente paciente) {
        PACIENTE_DAO.buscarPeloID(paciente.getId());
        return null;
    }
    
    public List<Paciente> buscarPcidade(String cidade) {
        try {
            return PACIENTE_DAO.buscarPorCidade(cidade);
        } 
        catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }
    }
    
    public List<Paciente> buscarPestado (String estado) {
        try {
            return PACIENTE_DAO.buscarPorEstado(estado);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar pelo paciente.");
        }
    }
}
