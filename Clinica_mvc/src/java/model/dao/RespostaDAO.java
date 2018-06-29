package model.dao;

import model.entidades.Resposta;

public interface RespostaDAO extends DAO<Resposta> {
    
    public Resposta buscarPorIDpergunta(long idPergunta);
}
