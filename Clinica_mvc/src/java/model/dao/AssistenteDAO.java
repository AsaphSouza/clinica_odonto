package model.dao;

import model.entidades.Assistente;

public interface AssistenteDAO extends DAO<Assistente>{
    
    public Assistente buscarPorNome(String nome);
}
