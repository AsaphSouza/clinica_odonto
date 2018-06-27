package model.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPergunta", nullable = false)
    private Long id;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name = "idQuestionario", referencedColumnName = "idQuestionario")
    @ManyToOne
    private Questionario questionario;
    
    @JoinColumn(name = "cro", referencedColumnName = "cro")
    @ManyToOne
    private Dentista dentistaa;
    
    @OneToMany(mappedBy = "pergunta")
    private List<Resposta> respostas;

    public Pergunta() {
    }

    public Pergunta(String descricao, String tipo, Questionario questionario, Dentista dentista) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.questionario = questionario;
        this.dentistaa = dentista;
    }

    

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Dentista getDentista() {
        return dentistaa;
    }

    public void setDentista(Dentista dentista) {
        this.dentistaa = dentista;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,descricao,tipo);
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
        final Pergunta other = (Pergunta) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pergunta{" + "id=" + id + ", descricao=" + descricao + ", tipo=" 
                + tipo + ", questionario=" + questionario + ", dentista=" + dentistaa 
                + ", respostas=" + respostas + '}';
    }
    
}
