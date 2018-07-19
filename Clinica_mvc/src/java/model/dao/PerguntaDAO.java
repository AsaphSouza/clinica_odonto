package model.dao;

import java.util.List;

import model.entidades.Pergunta;

public interface PerguntaDAO extends DAO<Pergunta> {
    
    public List<Pergunta> buscarPorTipo(String tipo);
    
    public Pergunta buscarPorIDquestionario (long idQuestionario);
}
