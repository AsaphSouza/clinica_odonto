package model.dao;

import model.entidades.Medicamento;

public interface MedicamentoDAO extends DAO<Medicamento>{
    
    public Medicamento buscarPorNome(String nome);
}
