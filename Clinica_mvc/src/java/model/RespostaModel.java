package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.RespostaHibernate;
import model.dao.RespostaDAO;
import model.entidades.Resposta;

public class RespostaModel {
	private RespostaDAO respostaDao;
	
	public RespostaModel() {
		respostaDao = new RespostaHibernate();
	}
	
	public void inserirResposta (Resposta resposta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			respostaDao.inserir(resposta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir resposta."));
		}
	}
	public void atualizarResposta(Resposta resposta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			respostaDao.atualizar(resposta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar resposta."));
		}
	}
	public void deletarResposta (Resposta resposta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			respostaDao.deletar(resposta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar resposta."));
		}
	}
}
