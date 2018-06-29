package model.dao;

import java.util.Date;
import model.entidades.Consulta;

public interface ConsultaDao extends DAO<Consulta> {

	public Consulta buscarPorDia(Date data);
        
        public Consulta buscarPorPeriodo(Date dataInicial, Date dataFinal);

}
