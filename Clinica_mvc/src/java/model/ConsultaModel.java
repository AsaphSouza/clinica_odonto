package model;

import model.dao.ConsultaDao;
import model.Hibernate.ConsultaHibernate;
import model.entidades.Consulta;
import java.security.InvalidParameterException;
import java.util.List;

public class ConsultaModel {

    private ConsultaDao dao;
    private List<Consulta> lista;

    public ConsultaModel() {
        this.dao = new ConsultaHibernate();
    }

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
            if (c.equals(c)) {
                return consulta;
            }
        }

        return null;
    }

}
