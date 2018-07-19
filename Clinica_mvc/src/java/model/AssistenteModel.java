package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.AssistenteHibernate;
import model.dao.AssistenteDAO;
import model.entidades.Assistente;

public class AssistenteModel {
    private AssistenteDAO assistenteDao;
    
    public AssistenteModel () {
        this.assistenteDao = new AssistenteHibernate();
    }
    
    public void inserirAssistente(Assistente assistente) {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (assistenteDao.buscarPorNome(assistente.getNome()) == null) {
            assistenteDao.inserir(assistente);
        } else {
            context.addMessage(null, new FacesMessage("Assistente já cadastrado."));
        }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro na base de dados."));
        }
    }
    
    public void atualizarAssistente (Assistente assistente) {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteDao.atualizar(assistente);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro ao atualizar Assistente."));
        }
    }
    
    public void deletarAssistente (Assistente assistente) {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            assistenteDao.deletar(assistente);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro ao deletar Assistente."));
        }
    }
    
    public Assistente buscarAssistente (String nome) {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            return assistenteDao.buscarPorNome(nome);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro ao buscar Assistente."));
            return null;
        }
    }
}
