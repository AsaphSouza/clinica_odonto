package model;

import model.entidades.Recepcionista;
import model.Hibernate.RecepcionistaHibernate;
import model.dao.RecepcionistaDao;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class RecepcionistaModel {
	private RecepcionistaDao recepcionistaDao;
	
	public RecepcionistaModel () {
		recepcionistaDao = new RecepcionistaHibernate();
	}
	
	public void inserirRecepcionista (Recepcionista recepcionista) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (recepcionistaDao.BuscarPorNome(recepcionista.getNome()) == null) {
				recepcionistaDao.inserir(recepcionista);
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir recepcionista."));
		}
	}
	public void atualizarRecepcionista(Recepcionista recepcionista) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			recepcionistaDao.atualizar(recepcionista);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar recepcionista."));
		}
	}
	public void deletarRecepcionista (Recepcionista recepcionista) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			recepcionistaDao.deletar(recepcionista);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar recepcionista."));
		}
	}
	public Recepcionista buscarPeloNome (String nome) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return recepcionistaDao.BuscarPorNome(nome);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar por nome."));
			return null;
		}
	}
}
