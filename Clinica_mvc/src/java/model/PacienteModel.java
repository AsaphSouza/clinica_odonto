package model;

import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class PacienteModel {

	private List<Paciente> lista;

	public void marcarConsulta() {// as requisi��es que ir�o serem feitas no sistema deve ficar no "model"
		// aqui marcará a consulta
	}

	public void marcarExame() {
		// aqui marcará o exame
	}

	public void cancelarEC() {
		// aqui cancela os exames ou consultas
	}

	public PacienteModel() {
		this.lista = new ArrayList<>();
	}

	public void inserirPaciente(Paciente paciente) {

		Paciente p = pegar(paciente);
		if (p == null) {
			lista.add(paciente);
		} else {
			throw new InvalidParameterException("Paciente já existe.");
		}

	}

	public void atualizarPaciente(Paciente p) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(p)) {
				lista.set(i, p);
				return;
			}
		}

		throw new InvalidParameterException("Paciente não existe");
	}

	public void deletarPaciente(Paciente p) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(p)) {
				lista.remove(i);
				return;
			}
		}

		throw new InvalidParameterException("Paciente não existe");
	}

	private Paciente pegar(Paciente p) {
		for (Paciente paciente : lista) {
			if (paciente.equals(p))
				return paciente;
		}

		return null;
	}

}
