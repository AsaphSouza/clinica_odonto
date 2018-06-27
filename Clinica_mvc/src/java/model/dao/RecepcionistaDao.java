package model.dao;

import model.entidades.Recepcionista;

public interface RecepcionistaDao extends DAO<Recepcionista> {

	public Recepcionista procurarPeloidRecepcionista(int idRecepcionista);
}
