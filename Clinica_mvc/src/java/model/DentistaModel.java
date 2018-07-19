package model;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Hibernate.DentistaHibernate;
import model.dao.DentistaDao;
import model.entidades.Dentista;

public class DentistaModel {
    private DentistaDao dentistaDao;
    
    public DentistaModel () {
    	dentistaDao = new DentistaHibernate();
    }
    
    public void inserirDentista(Dentista dentista) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			if (dentistaDao.BuscarPeloCRO(dentista.getCro()) == null) {
				dentistaDao.inserir(dentista);
			} else {
				context.addMessage(null, new FacesMessage("Dentista já cadastrado."));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao cadastrar dentista."));
		}
    }
    public void atualizarDentista(Dentista dentista) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			dentistaDao.atualizar(dentista);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao atualizar dentista."));
		}
    }
    
    public void deletarDentista(Dentista dentista) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			dentistaDao.deletar(dentista);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro ao deletar dentista"));
		}
    }
    
    public Dentista buscarPorCRO (String cro) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	try {
			return dentistaDao.BuscarPeloCRO(cro);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Erro na busca do dentista."));
			return null;
		}
    }
    
}