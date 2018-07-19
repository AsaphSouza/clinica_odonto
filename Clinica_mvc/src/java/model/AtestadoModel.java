package model;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.AtestadoHibernate;
import model.dao.AtestadoDAO;
import model.entidades.Atestado;

public class AtestadoModel {
	private AtestadoDAO atestadoDao;
	public AtestadoModel() {
		this.atestadoDao = new AtestadoHibernate();
	}
	
	public void inserirAtestado (Atestado atestado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			atestadoDao.inserir(atestado);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir atestado."));
		}
	}
	
	public void atualizarAtestado (Atestado atestado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			atestadoDao.atualizar(atestado);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar atestado."));
		}
	}

	public void deletarAtestado (Atestado atestado) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			atestadoDao.deletar(atestado);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar atestado."));
		}
	}
	
	public List<Atestado> buscarPeloTipo (String tipo) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return  atestadoDao.buscarPorTipo(tipo);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar atestado."));
			return null;
		}
	}
}
