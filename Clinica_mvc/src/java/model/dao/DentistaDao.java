package model.dao;

import model.entidades.Dentista;

public interface DentistaDao extends DAO<Dentista> {

	public Dentista BuscarPeloCRO(String cro);

}
