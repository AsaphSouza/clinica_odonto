package model.entidades;

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
@Table(name = "dentista")
public class Dentista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cro", nullable = false)
    private Long cro;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "formacao", nullable = false)
    private String formacao;
    
    @OneToMany(mappedBy = "dentista")
    private List<Consulta> consultas;
    
    @OneToMany(mappedBy = "dentistaa")
    private List<Pergunta> perguntas;
    
    @OneToMany(mappedBy = "dentista")
    private List<Resposta> respostas;

    public Dentista() {
    }
    
    public Dentista (Long cro, String nome, String formacao) {
	this.cro = cro;
	this.nome = nome;
	this.formacao = formacao;
    }
    
    public Dentista (String nome, String formacao) {
	this.cro = cro;
	this.nome = nome;
	this.formacao = formacao;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
    
    public Long getCro() {
        return cro;
    }

    public void setCro(Long cro) {
        this.cro = cro;
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
    
    
    @Override
    public int hashCode() {
        return Objects.hash(cro, nome, formacao);
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
        final Dentista dent = (Dentista) obj;
        if (!Objects.equals(this.cro, dent.cro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dentista{" + "cro=" + cro + ", nome=" + nome + ", formacao=" 
                + formacao + ", consultas=" + consultas + ", perguntas=" + perguntas 
                + ", respostas=" + respostas + '}';
    }

    
}
