package model.dao;

import model.entidades.Consulta;

public interface ConsultaDao extends DAO<Consulta> {

	public Consulta procuraPeloidConsulta(int idConsulta);

}
