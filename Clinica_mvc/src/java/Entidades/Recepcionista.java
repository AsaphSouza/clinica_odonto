package Entidades;

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

    public Recepcionista(String nome, String formacao) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recepcionista recepcionista = (Recepcionista) obj;
        return Objects.equals(this.id, recepcionista.id);
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "id=" + id + ", nome=" + nome + ", formacao=" + formacao + ", consultas=" + consultas + ", examesMarcados=" + examesMarcados + '}';
    }

}
