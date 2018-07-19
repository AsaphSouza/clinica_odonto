package model.dao;

import model.entidades.Questionario;
import java.util.List;
import model.entidades.Pergunta;

public interface QuestionarioDAO extends DAO<Questionario>{
    
    public List<Pergunta> buscarPorNome(String nome);
}
