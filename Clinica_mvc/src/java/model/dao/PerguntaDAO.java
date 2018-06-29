package model.dao;

import model.entidades.Pergunta;

public interface PerguntaDAO extends DAO<Pergunta> {
    
    public Pergunta buscarPorTipo(String tipo);
    
    public Pergunta buscarPorIDquestionario (long idQuestionario);
}
