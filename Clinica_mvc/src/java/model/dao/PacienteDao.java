package model.dao;

import java.util.List;
import model.entidades.Paciente;

public interface PacienteDao extends DAO<Paciente> {
        
        public Paciente buscarPeloCPF (String cpf);
        
        public List<Paciente> buscarPorCidade (String cidade);
        
        public List<Paciente> buscarPorEstado (String estado);
        
        public List<Paciente> listarTodos ();
        
}
