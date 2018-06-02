package model;

public interface PacienteDao extends DAO<Paciente> {

	public Paciente procurarPeloidPaciente(int idPaciente);

}
