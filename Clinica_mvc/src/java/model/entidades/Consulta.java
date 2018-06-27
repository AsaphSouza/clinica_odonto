package model.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
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
    
    @Column(name = "dataHora", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data;
    
    @JoinColumn(name = "cro", referencedColumnName = "cro")
    @ManyToOne
    private Dentista dentista;
    
    @JoinColumn(name = "idAssistente", referencedColumnName = "idAssistente")
    @ManyToOne
    private Assistente assistente;
    
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "idRecepcionista", referencedColumnName = "idRecepcionista")
    @ManyToOne
    private Recepcionista recepcionista;
    
    @Column(name = "dataMarcacao", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcacao;
    
    @JoinTable (name = "consulta_emissao_medicamento",
            joinColumns = {@JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta")},
            inverseJoinColumns = {@JoinColumn(name = "idMedicamento", referencedColumnName = "idMedicamento")})
    @ManyToMany
    private List<Medicamento> medicamentos;
    
    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames;
    
    
    @OneToMany(mappedBy = "consulta")
    private List<Atestado> atestados;

    public Consulta(String tipo, String meio, Date data, Dentista dentista,
            Assistente assistente, Paciente paciente, Recepcionista recepcionista,
            Date dataMarcacao) {
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
        return Objects.hash(id, tipo, meio, data, dataMarcacao);
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
        Consulta consul = (Consulta) obj;
        if (!Objects.equals(this.id, consul.id)) {
            return false;
        }
        return Objects.equals(this.data, consul.data);
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", tipo=" + tipo + ", meio=" + meio 
                + ", data=" + data + ", dentista=" + dentista + ", assistente=" 
                + assistente + ", paciente=" + paciente + ", recepcionista=" 
                + recepcionista + ", dataMarcacao=" + dataMarcacao + ", medicamentos=" 
                + medicamentos + ", exames=" + exames + ", atestados=" + atestados + '}';
    }

}
