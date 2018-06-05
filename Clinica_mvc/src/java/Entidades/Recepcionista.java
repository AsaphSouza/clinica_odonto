package Entidades;

import Entidades.Exame;
import Entidades.Consulta;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recepcionista")
public class Recepcionista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecepcionista",nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "formacao", nullable = false)
    private String formacao;
    
    @OneToMany(mappedBy = "recepcionista")
    private List<Consulta> consultas;
    
    @OneToMany(mappedBy = "recepcionista")
    private List<Exame> examesMarcados;
    
    public Recepcionista() {
    }

    public Recepcionista(Long id, String nome, String formacao) {
        this.id = id;
        this.nome = nome;
        this.formacao = formacao;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Exame> getExamesMarcados() {
        return examesMarcados;
    }

    public void setExamesMarcados(List<Exame> examesMarcados) {
        this.examesMarcados = examesMarcados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome,formacao);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Recepcionista)) {
            return false;
        }
        Recepcionista other = (Recepcionista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recepcionistaa[ id=" + id + " ]";
    }

}
