package model.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "exame")
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExame", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column (name = "tempoEstimado")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date tempoEstimado;
    
    @Column(name = "resultado")
    private String resultado;
    
    @JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta")
    @ManyToOne
    private Consulta consulta;
    
    @Column(name = "dataMarcacaoPaciente")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcacaoP;
    
    @Column(name = "dataMarcacaoRecepcionista")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcacaoR;
    
    @JoinColumn(name = "idRecepcionista", referencedColumnName = "idRecepcionista")
    @ManyToOne
    private Recepcionista recepcionista;
    
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne
    private Paciente paciente;

    public Exame() {
    }

    public Exame(Long id, String nome, String descricao, String status,
            Date tempoEstimado, String resultado, Consulta consulta,
            Date dataMarcacaoP, Date dataMarcacaoR, Recepcionista recepcionista,
            Paciente paciente) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.tempoEstimado = tempoEstimado;
        this.resultado = resultado;
        this.consulta = consulta;
        this.dataMarcacaoP = dataMarcacaoP;
        this.dataMarcacaoR = dataMarcacaoR;
        this.recepcionista = recepcionista;
        this.paciente = paciente;
    }

    

    public Date getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Date tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getResultado() {
        return resultado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Date getDataMarcacaoP() {
        return dataMarcacaoP;
    }

    public void setDataMarcacaoP(Date dataMarcacaoP) {
        this.dataMarcacaoP = dataMarcacaoP;
    }

    public Date getDataMarcacaoR() {
        return dataMarcacaoR;
    }

    public void setDataMarcacaoR(Date dataMarcacaoR) {
        this.dataMarcacaoR = dataMarcacaoR;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.tempoEstimado);
        hash = 37 * hash + Objects.hashCode(this.resultado);
        hash = 37 * hash + Objects.hashCode(this.consulta);
        hash = 37 * hash + Objects.hashCode(this.dataMarcacaoP);
        hash = 37 * hash + Objects.hashCode(this.dataMarcacaoR);
        hash = 37 * hash + Objects.hashCode(this.recepcionista);
        hash = 37 * hash + Objects.hashCode(this.paciente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Exame.class != obj.getClass()) {
            return false;
        }
        
        Exame ex = (Exame) obj;
        return Objects.equals(this.id, ex.getId()); 
    }

    @Override
    public String toString() {
        return "Exame{" + "id=" + id + ", nome=" + nome + ", descricao=" + 
                descricao + ", status=" + status + ", tempoEstimado=" + 
                tempoEstimado + ", resultado=" + resultado + ", consulta=" 
                + consulta + ", dataMarcacaoP=" + dataMarcacaoP + ", dataMarcacaoR=" 
                + dataMarcacaoR + ", recepcionista=" + recepcionista + ", paciente=" 
                + paciente + '}';
    }

    



}
