package model;

import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.List;
import model.Hibernate.PacienteHibernate;
import model.dao.PacienteDao;

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
        
        if (cpf.validarCpf(paciente.getCpf()) == false) {
            // cpf não é válido
            throw new InvalidParameterException("CPF não é válido.");
        } else {
            if (pacienteDao.buscarPeloCPF(paciente.getCpf()) == null) {
                pacienteDao.inserir(paciente);
                // paciente cadastrado com sucesso
            } else {
                // paciente já cadastrado na base de dados
                throw new InvalidParameterException("Paciente já cadastrado na base de dados.");
            }
        }

    }

    public void atualizarPaciente(Paciente paciente) {
        try {
            pacienteDao.atualizar(paciente);
            //Dados atualizados com sucesso!
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao atualizar os dados do paciente.");
        }
       
    }

    public void deletarPaciente(Paciente paciente) {
        //tem certeza que deseja deletar o paciente?
        pacienteDao.deletar(paciente);
        //Paciente excluido com sucesso da base de dados!
    }

    public Paciente buscarpPorCPF(Paciente paciente) {
        return pacienteDao.buscarPeloCPF(paciente.getCpf());
    }
    
    public Paciente buscarPorID (Paciente paciente) {
        pacienteDao.buscarPeloID(paciente.getId());
        return null;
    }

}
