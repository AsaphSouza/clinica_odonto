package model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaModel {

	private List<Consulta> lista;
        DAO hcd = new HibernateConsultaDao();
        
        

    public List<Consulta> getLista() {
        return lista;
    }

    public void setLista(List<Consulta> lista) {
        this.lista = lista;
    }
        
	public void emissaoAtestado() {
    
	}

	public void prescreverExame() {
           
	}

	public void prescreverMedicamento() {
            
	}

	public ConsultaModel() {
		this.lista = new ArrayList<>();
	}

	public void inserirConsulta(Consulta consulta) {

		Consulta c = pegar(consulta);
		if (c == null) {
			lista.add(consulta);
		} else {
			throw new InvalidParameterException("Consulta j� existe");
		}

	}

	public void atualizarConsulta(Consulta c) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(c)) {
				lista.set(i, c);
				return;
			}
		}

		throw new InvalidParameterException("Consulta n�o existe");
	}

	public void deletarConsulta(Consulta c) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(c)) {
				lista.remove(i);
				return;
			}
		}

		throw new InvalidParameterException("Consulta n�o existe");
	}

	private Consulta pegar(Consulta c) {
		for (Consulta consulta : lista) {
			if (c.equals(c))
				return consulta;
		}

		return null;
	}

}
