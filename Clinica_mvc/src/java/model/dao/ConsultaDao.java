package model.dao;

import java.util.Date;
import java.util.List;
import model.entidades.Consulta;

public interface ConsultaDao extends DAO<Consulta> {

	public List<Consulta> buscarPorDia(Date data);
        
        public List<Consulta> buscarPorPeriodo(Date dataInicial, Date dataFinal);
        
        public List<Consulta> buscarPorMes (Date data);

}
