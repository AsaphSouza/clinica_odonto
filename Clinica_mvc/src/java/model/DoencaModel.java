package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.DoencaHibernate;
import model.dao.DoencaDAO;
import model.entidades.Doenca;

public class DoencaModel {
	DoencaDAO dao;
	
	public DoencaModel () {
		dao = new DoencaHibernate();
	}
	
	public void inserirDoenca (Doenca doenca) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (dao.buscarPorNome(doenca.getNome()) == null) {
				dao.inserir(doenca);
			} else {
				context.addMessage(null, new FacesMessage("Doença já cadstrada no banco de dados."));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir doença."));
		}
	}
	public void atualizarDoenca (Doenca doenca) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.atualizar(doenca);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar Doença."));
		}
	}
	public void deletarDentista (Doenca doenca) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.deletar(doenca);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar doença."));
		}
	}
	public Doenca buscarPeloNome (String nome) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return dao.buscarPorNome(nome);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar pelo nome."));
			return null;
		}
	}
}
