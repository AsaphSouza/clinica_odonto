package model;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.QuestionarioHibernate;
import model.dao.QuestionarioDAO;
import model.entidades.Pergunta;
import model.entidades.Questionario;

public class QuestionarioModel {
	private QuestionarioDAO questionarioDao;
	
	public QuestionarioModel () {
		questionarioDao = new QuestionarioHibernate();
	}
	
	public void inserirQuestionario (Questionario questionario) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (questionarioDao.buscarPorNome(questionario.getNome()) == null) {
				questionarioDao.inserir(questionario);
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir Questionario."));
		}
	}
	public void atualizarQuestionario(Questionario questionario) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			questionarioDao.atualizar(questionario);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar questionario."));
		}
	}
	public void deletarQuestionario (Questionario questionario) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			questionarioDao.deletar(questionario);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar questionario."));
		}
	}
	public List<Pergunta> buscarPeloNome (String nome) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return questionarioDao.buscarPorNome(nome);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar questionario por nome."));
			return null;
		}
	}
}
