package DAO;

import Entidades.Dentista;

public interface DentistaDao extends DAO<Dentista> {

	public Dentista procurarPelocro(int cro);

}
