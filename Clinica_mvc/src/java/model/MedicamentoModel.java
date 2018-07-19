package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.MedicamentoHibernate;
import model.dao.MedicamentoDAO;
import model.entidades.Medicamento;

public class MedicamentoModel {
	private MedicamentoDAO medicamentoDao;
	
	public MedicamentoModel () {
		medicamentoDao = new MedicamentoHibernate();
	}
	public void inserirMedicanto (Medicamento medicamento) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (medicamentoDao.buscarPorNome(medicamento.getNome()) == null) {
				medicamentoDao.inserir(medicamento);
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir medicamento."));
		}
	}
	public void atualizarMedicamento(Medicamento medicamento) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			medicamentoDao.atualizar(medicamento);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar medicamento."));
		}
	}
	public void deletarMedicamento (Medicamento medicamento) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			medicamentoDao.deletar(medicamento);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar medicamento."));
		}
	}
	public Medicamento buscarPeloNome (String nome) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return medicamentoDao.buscarPorNome(nome);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar medicamento por nome."));
			return null;
		}
	}
}
