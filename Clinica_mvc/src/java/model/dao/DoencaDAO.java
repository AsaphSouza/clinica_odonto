package model.dao;

import model.entidades.Doenca;

public interface DoencaDAO extends DAO<Doenca>{
    
    public Doenca buscarPorNome(String nome);
}
