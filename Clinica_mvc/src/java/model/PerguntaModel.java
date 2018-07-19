package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.PerguntaHibernate;
import model.dao.PerguntaDAO;
import model.entidades.Pergunta;

public class PerguntaModel {
	private PerguntaDAO perguntaDao;
	
	public PerguntaModel () {
		perguntaDao = new PerguntaHibernate();
	}
	
	public void inserirPergunta (Pergunta pergunta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (perguntaDao.buscarPorTipo(pergunta.getTipo()) == null) {
				perguntaDao.inserir(pergunta);
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir pergunta."));
		}
	}
	public void atualizarPergunta(Pergunta pergunta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			perguntaDao.atualizar(pergunta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar pergunta."));
		}
	}
	public void deletarPergunta (Pergunta pergunta) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			perguntaDao.deletar(pergunta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar pergunta."));
		}
	}
	
}
