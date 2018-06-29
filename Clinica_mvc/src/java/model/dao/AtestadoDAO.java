package model.dao;

import model.entidades.Atestado;

public interface AtestadoDAO extends DAO<Atestado>{
    
    public Atestado buscarPorTipo(String tipo);
    
    public Atestado buscarPorIDconsulta(int idConsulta);
}
