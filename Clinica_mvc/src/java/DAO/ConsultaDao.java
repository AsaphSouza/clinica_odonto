package DAO;

import Entidades.Consulta;

public interface ConsultaDao extends DAO<Consulta> {

	public Consulta procuraPeloidConsulta(int idConsulta);

}
