package Entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assistente")
public class Assistente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAssistente", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "formacao", nullable = false)
    private String formacao;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "assistente")
    private List<Consulta> consultas;
    
    public Assistente() {
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Assistente(String nome, String formacao) {
        this.nome = nome;
        this.formacao = formacao;
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
        return Objects.hash(id, nome, formacao);
    }

    @Override
    public boolean equals(Object ass) {
        if (this == ass) {
            return true;
        }
        if (!(ass instanceof Assistente)) {
            return false;
        }
        Assistente other = (Assistente) ass;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Assistente{" + "id=" + id + ", nome=" + nome + ", formacao=" + 
                formacao + ", consultas=" + consultas + '}';
    }

    

}
