package model.dao;

public interface DAO<T> {

    public void inserir(T obj);

    public void atualizar(T obj);

    public void deletar(T obj);

    public long buscarPeloID(long id);
}
