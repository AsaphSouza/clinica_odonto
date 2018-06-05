package DAO;

import Entidades.Recepcionista;

public interface RecepcionistaDao extends DAO<Recepcionista> {

	public Recepcionista procurarPeloidRecepcionista(int idRecepcionista);
}
