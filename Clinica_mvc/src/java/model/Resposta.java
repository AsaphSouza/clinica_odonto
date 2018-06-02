package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResposta", nullable = false)
    private Long id;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @JoinColumn(name = "FK_PERGUNTA", referencedColumnName = "idPergunta")
    @ManyToOne
    private Pergunta pergunta;
    
    @JoinColumn(name = "FK_DENTISTA", referencedColumnName = "idDentista")
    @ManyToOne
    private Dentista dentista;
    
    @JoinColumn(name = "FK_DOENCA", referencedColumnName = "idDoenca")
    @JoinTable (name = "doenca_tem_resposta",
            joinColumns = {@JoinColumn(name = "FK_DOENCA", referencedColumnName = "idDoenca")},
            inverseJoinColumns = {@JoinColumn(name = "FK_RESPOSTA", referencedColumnName = "idResposta")})
    @ManyToMany
    private List<Doenca> doencas;
    
    @JoinColumn(name = "FK_MEDICAMENTO", referencedColumnName = "idMedicamento")
    @JoinTable (name = "medicamento_tem_resposta",
            joinColumns = {@JoinColumn(name = "FK_MEDICAMENTO", referencedColumnName = "idMedicamento")},
            inverseJoinColumns = {@JoinColumn(name = "FK_RESPOSTA", referencedColumnName = "idResposta")})
    @ManyToMany
    private List<Medicamento> medicamentos;

    public Resposta() {
    }

    public Resposta(Long id, String descricao, Pergunta pergunta, Dentista dentista, 
            List<Doenca> doencas, List<Medicamento> medicamentos) {
        this.id = id;
        this.descricao = descricao;
        this.pergunta = pergunta;
        this.dentista = dentista;
        this.doencas = doencas;
        this.medicamentos = medicamentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public List<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<Doenca> doencas) {
        this.doencas = doencas;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getDrescricao() {
        return descricao;
    }

    public void setDrescricao(String drescricao) {
        this.descricao = drescricao;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Resposta[ id=" + id + " ]";
    }
    
}
