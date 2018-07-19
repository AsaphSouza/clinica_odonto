package model;

import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.ExameHibernate;
import model.dao.ExameDAO;
import model.entidades.Exame;

public class ExameModel {
	private ExameDAO dao;
	
	public ExameModel () {
		dao = new ExameHibernate();
	}
	
	public void inserirExame (Exame exame) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (dao.buscarPorNome(exame.getNome()) == null) {
				dao.inserir(exame);
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir exame."));
		}
	}
	public void atualizarExame(Exame exame) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.atualizar(exame);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar exame."));
		}
	}
	public void deletarExame (Exame exame) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.deletar(exame);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar exame."));
		}
	}
	public Exame buscarPeloNome (String nome) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return dao.buscarPorNome(nome);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar por nome."));
			return null;
		}
	}
	public List<Exame> buscarPeloDia (Date data) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return dao.buscarPorDia(data);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar exames por dia."));
			return null;
		}
	}
	public List<Exame> buscarPeloPeriodo (Date datainicial, Date dataFinal) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return dao.buscarPorPeriodo(datainicial, dataFinal);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar exames por período."));
			return null;
		}
	}
}
