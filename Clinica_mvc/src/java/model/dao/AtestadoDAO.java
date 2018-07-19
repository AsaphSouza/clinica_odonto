package model.dao;

import java.util.List;

import model.entidades.Atestado;

public interface AtestadoDAO extends DAO<Atestado>{
    
    public List<Atestado> buscarPorTipo(String tipo);
    
    public Atestado buscarPorIDconsulta(int idConsulta);
}
