package model.dao;

import model.entidades.Recepcionista;

public interface RecepcionistaDao extends DAO<Recepcionista> {

	public Recepcionista BuscarPorNome(String nome);
}
