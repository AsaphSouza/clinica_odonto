package Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.DentistaModel;
import model.entidades.Dentista;

@ManagedBean
@SessionScoped
public class ControllerDentista {

    private DentistaModel dentistaModel;
    private Dentista dentista;
    private String cro;

    public ControllerDentista() {
        dentistaModel = new DentistaModel();
        dentista = new Dentista();
    }

    public void cadastrarDentista() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            dentistaModel.inserirDentista(dentista);
            // context.addMessage(null, new FacesMessage("Cadastro Efetuado!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void deletarDentista() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            dentistaModel.deletarDentista(dentista);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public void atualizarDentista() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            dentistaModel.atualizarDentista(dentista);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
        }
    }

    public Dentista buscarPeloCRO() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            return dentistaModel.buscarPorCRO(cro);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public DentistaModel getDentistaModel() {
        return dentistaModel;
    }

    public void setDentistaModel(DentistaModel dentistaModel) {
        this.dentistaModel = dentistaModel;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

}
