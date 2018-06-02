package model;

public interface RecepcionistaDao extends DAO<Recepcionista> {

	public Recepcionista procurarPeloidRecepcionista(int idRecepcionista);
}
