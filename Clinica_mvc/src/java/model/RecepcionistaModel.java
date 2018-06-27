package model;

import model.entidades.Recepcionista;
import model.entidades.Paciente;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RecepcionistaModel {

	private List<Recepcionista> lista;

	// Exames e = new Exames(0, null, null, null);
	// Consulta c = new Consulta();
	public void marcarConsulta(Paciente paciente) {

	}

	public void marcarExame(Paciente paciente) {

	}

	public void cancelarEC(Paciente paciente) {

	}

	public RecepcionistaModel() {
		this.lista = new ArrayList<>();
	}

	public void inserirRecepcionista(Recepcionista recepcionista) {

		Recepcionista r = pegar(recepcionista);
		if (r == null) {
			lista.add(recepcionista);
		} else {
			throw new InvalidParameterException("Recepcionista j� existe");
		}

	}

	public void atualizarRecepcionista(Recepcionista r) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(r)) {
				lista.set(i, r);
				return;
			}
		}

		throw new InvalidParameterException("Recepcionista n�o existe");
	}

	public void deletarRecepcionista(Recepcionista r) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(r)) {
				lista.remove(i);
				return;
			}
		}

		throw new InvalidParameterException("Recepcionista n�o existe");
	}

	private Recepcionista pegar(Recepcionista r) {
		for (Recepcionista recepcionista : lista) {
			if (recepcionista.equals(r))
				return recepcionista;
		}

		return null;
	}

}
