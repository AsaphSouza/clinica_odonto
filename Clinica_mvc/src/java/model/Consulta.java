//essa é a classe mais trabalhosa que tem até agora!!!!
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsulta", nullable = false)
    private Long id;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "meio")
    private String meio;
    
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data;
    
    @JoinColumn(name = "FK_DENTISTA", referencedColumnName = "cro")
    @ManyToOne
    private Dentista dentista;
    
    @JoinColumn(name = "FK_ASSISTENTE", referencedColumnName = "idAssistente")
    @ManyToOne
    private Assistente assistente;
    
    @JoinColumn(name = "FK_PACIENTE", referencedColumnName = "idPaciente")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "FK_RECEPCIONISTA", referencedColumnName = "idRecepcionista")
    @ManyToOne
    private Recepcionista recepcionista;
    
    @Column(name = "dataMarcacao", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcacao;
    
    @JoinTable (name = "consulta_emissao_medicamento",
            joinColumns = {@JoinColumn(name = "FK_CONSULTA", referencedColumnName = "idConsulta")},
            inverseJoinColumns = {@JoinColumn(name = "FK_MEDICAMENTO", referencedColumnName = "idMedicamento")})
    @ManyToMany
    private List<Medicamento> medicamentos;

    public Consulta(Long id, String tipo, String meio, Date data, Dentista dentista, Assistente assistente, Paciente paciente, Recepcionista recepcionista, Date dataMarcacao) {
        this.id = id;
        this.tipo = tipo;
        this.meio = meio;
        this.data = data;
        this.dentista = dentista;
        this.assistente = assistente;
        this.paciente = paciente;
        this.recepcionista = recepcionista;
        this.dataMarcacao = dataMarcacao;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Consulta() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Assistente getAssistente() {
        return assistente;
    }

    public void setAssistente(Assistente assistente) {
        this.assistente = assistente;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
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
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consultaa[ id=" + id + " ]";
    }

}
