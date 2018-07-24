package model.dao;

import java.util.List;
import model.entidades.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{
    public List<Usuario> listarTodos ();
    public List<Usuario> listarPorTipo(String tipo);
    public Usuario buscarPorUser(String user);
}
