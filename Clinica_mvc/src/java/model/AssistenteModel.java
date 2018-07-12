package model;

import java.security.InvalidParameterException;
import model.Hibernate.AssistenteHibernate;
import model.dao.AssistenteDAO;
import model.entidades.Assistente;
import org.hibernate.HibernateException;

public class AssistenteModel {
    private final AssistenteDAO ASSISTENTE_DAO;
    
    public AssistenteModel () {
        this.ASSISTENTE_DAO = new AssistenteHibernate();
    }
    
    public void inserirAssistente(Assistente assistente) {
        try {
            if (ASSISTENTE_DAO.buscarPorNome(assistente.getNome()) == null) {
            ASSISTENTE_DAO.inserir(assistente);
        } else {
            throw new InvalidParameterException("Assistente já existe na base de dados.");
        }
        } catch (HibernateException e) {
            throw new InvalidParameterException("Erro na base de dados.");
        }
    }
    
    public void atualizarAssistente (Assistente assistente) {
        try {
            ASSISTENTE_DAO.atualizar(assistente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao atualizar Assistente.");
        }
    }
    
    public void deletarAssistente (Assistente assistente) {
        try {
            ASSISTENTE_DAO.deletar(assistente);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao deltetar Assistente.");
        }
    }
    
    public Assistente buscarAssistente (String nome) {
        try {
            ASSISTENTE_DAO.buscarPorNome(nome);
        } catch (Exception e) {
            throw new InvalidParameterException("Erro ao buscar Assistente.");
        }
        return null;
    }
}
