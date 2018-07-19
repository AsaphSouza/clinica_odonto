package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.EnderecoHibernate;
import model.dao.EnderecoDAO;
import model.entidades.Endereco;

public class EnderecoModel {
	private EnderecoDAO enderecoDao;
	
	public EnderecoModel () {
		enderecoDao = new EnderecoHibernate();
	}
	public void inserirEndereco (Endereco endereco) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			enderecoDao.inserir(endereco);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir endereco."));
		}
	}
	public void atualizarEndereco(Endereco endereco) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			enderecoDao.atualizar(endereco);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar endereco."));
		}
	}
	public void deletarEndereco (Endereco endereco) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			enderecoDao.deletar(endereco);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar endereco."));
		}
	}
}
