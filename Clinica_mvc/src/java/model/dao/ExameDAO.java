package model.dao;

import java.util.Date;
import java.util.List;

import model.entidades.Exame;

public interface ExameDAO extends DAO<Exame>{
    
    public Exame buscarPorNome (String nome);
    
    public List<Exame> buscarPorIDconsulta (long idConsulta);
    
    public List<Exame> buscarPorIDpaciente (long idPaciente);
    
    public List<Exame> buscarPorDia (Date data);
    
    public List<Exame> buscarPorPeriodo (Date dataInicial, Date dataFinal);
}
