package model.dao;

import java.util.Date;
import model.entidades.Exame;

public interface ExameDAO extends DAO<Exame>{
    
    public Exame buscarPorNome (String nome);
    
    public Exame buscarPorIDconsulta (long idConsulta);
    
    public Exame buscarPorIDpaciente (long idPaciente);
    
    public Exame buscarPorDia (Date data);
    
    public Exame buscarPorPeriodo (Date dataInicial, Date dataFinal);
}
