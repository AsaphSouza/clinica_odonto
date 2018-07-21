package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.RecepcionistaModel;
import model.entidades.Recepcionista;

@ManagedBean
@SessionScoped
public class ControllerRecepcionista {
    private RecepcionistaModel recepcionistaModel;
    private Recepcionista recepcionista;
    private String nome;
    
    public ControllerRecepcionista () {
    	recepcionistaModel = new RecepcionistaModel();
    	recepcionista = new Recepcionista();
    }
    
    public void cadastrarRecepcionista () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            recepcionistaModel.inserirRecepcionista(recepcionista);
            //context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }
    
    public void deletarRecepcionista () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            recepcionistaModel.deletarRecepcionista(recepcionista);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }
    
    public void atualizarRecepcionista () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            recepcionistaModel.atualizarRecepcionista(recepcionista);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }
    
    public Recepcionista buscarPorNome () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return recepcionistaModel.buscarPeloNome(nome);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return  null;
        }
    }

	public RecepcionistaModel getRecepcionistaModel() {
		return recepcionistaModel;
	}

	public void setRecepcionistaModel(RecepcionistaModel recepcionistaModel) {
		this.recepcionistaModel = recepcionistaModel;
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
}
