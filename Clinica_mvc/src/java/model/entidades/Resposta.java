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
    
    @JoinColumn(name = "idPergunta", referencedColumnName = "idPergunta")
    @ManyToOne
    private Pergunta pergunta;
    
    @JoinColumn(name = "iddentita", referencedColumnName = "iddentista")
    @ManyToOne
    private Dentista dentista;
    
    //@JoinColumn(name = "FK_DOENCA", referencedColumnName = "idDoenca")
    @JoinTable (name = "doenca_tem_resposta",
            joinColumns = {@JoinColumn(name = "idResposta", referencedColumnName = "idResposta")},
            inverseJoinColumns = {@JoinColumn(name = "idDoenca", referencedColumnName = "idDoenca")})
    @ManyToMany
    private List<Doenca> doencas;
    
    //@JoinColumn(name = "FK_MEDICAMENTO", referencedColumnName = "idMedicamento")
    @JoinTable(name = "medicamento_tem_resposta",
            joinColumns = {@JoinColumn(name = "idResposta", referencedColumnName = "idResposta")},
            inverseJoinColumns = {@JoinColumn(name = "idMedicamento", referencedColumnName = "idMedicamento")})
    @ManyToMany
    private List<Medicamento> medicamentos;

    public Resposta() {
    }

    public Resposta(Long id, String descricao, Pergunta pergunta, Dentista dentista) {
        this.id = id;
        this.descricao = descricao;
        this.pergunta = pergunta;
        this.dentista = dentista;
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
        return Objects.hash(id,descricao,pergunta);
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
        final Resposta resposta = (Resposta) obj;
        return Objects.equals(this.id, resposta.id);
    }

    @Override
    public String toString() {
        return "Resposta{" + "id=" + id + ", descricao=" + descricao + ", pergunta=" 
                + pergunta + ", dentista=" + dentista + ", doencas=" + doencas 
                + ", medicamentos=" + medicamentos + '}';
    }
    
}
