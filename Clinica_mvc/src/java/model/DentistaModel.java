package model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class DentistaModel {

	private List<Dentista> lista;

	public void inserirPergunta() {

	}

	public void removerPergunta() {

	}

	public void alterarPergunta() {

	}

	public DentistaModel() {
		this.lista = new ArrayList<>();
	}

	public void inserirDentista(Dentista dentista) {

		Dentista d = pegar(dentista);
		if (d == null) {
			lista.add(dentista);
		} else {
			throw new InvalidParameterException("Dentista já existe");
		}

	}

	public void atualizarDentista(Dentista d) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(d)) {
				lista.set(i, d);
				return;
			}
		}

		throw new InvalidParameterException("Dentista não existe");
	}

	public void deletarDentista(Dentista d) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(d)) {
				lista.remove(i);
				return;
			}
		}

		throw new InvalidParameterException("Dentista não existe");
	}

	private Dentista pegar(Dentista d) {
		for (Dentista dentista : lista) {
			if (d.equals(d))
				return dentista;
		}

		return null;
	}

}
