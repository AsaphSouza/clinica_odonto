package DAO;

import Entidades.Paciente;

public interface PacienteDao extends DAO<Paciente> {

	public Paciente procurarPeloidPaciente(int idPaciente);

}
