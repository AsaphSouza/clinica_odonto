package model.dao;

import model.entidades.Questionario;

public interface QuestionarioDAO extends DAO<Questionario>{
    
    public Questionario buscarPorNome(String nome);
}
