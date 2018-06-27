package model.dao;

import model.entidades.Paciente;

public interface PacienteDao extends DAO<Paciente> {

	public Paciente procurarPeloidPaciente(int idPaciente);

}
