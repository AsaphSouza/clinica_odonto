package model;

import model.dao.ConsultaDao;
import model.Hibernate.ConsultaHibernate;
import model.entidades.Consulta;
import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ConsultaModel {

    private ConsultaDao dao;

    public ConsultaModel() {
        this.dao = new ConsultaHibernate();
    }

    public void emissaoAtestado() {

    }

    public void prescreverExame() {

    }

    public void prescreverMedicamento() {

    }

    public void inserirConsulta(Consulta consulta) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			dao.inserir(consulta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao inserir consulta."));
		}
    }

    public void atualizarConsulta(Consulta consulta) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			dao.atualizar(consulta);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar consulta."));
		}
    }

    public void deletarConsulta(Consulta c) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			dao.deletar(c);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar consulta."));
		}
    }

    public List<Consulta> buscarPeloDia (Date data) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			return dao.buscarPorDia(data);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar consulta por dia."));
			return null;
		}
    }
    
    public List<Consulta> buscarPeloPeriodo (Date inicial, Date dfinal) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			return dao.buscarPorPeriodo(inicial, dfinal);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar por período."));
			return null;
		}
    }
    
    public List<Consulta> buscarPeloMes (Date data) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			return dao.buscarPorMes(data);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao buscar por mes."));
			return null;
		}
    }

}