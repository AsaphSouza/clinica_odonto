package Entidades;

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
    
    @Column(name = "dataMarcacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcacao;
    
    @JoinColumn(name = "FK_RECEPCIONISTA", referencedColumnName = "idRecepcionista")
    @ManyToOne
    private Recepcionista recepcionista;
    
    @JoinColumn(name = "FK_PACIENTE", referencedColumnName = "idPaciente")
    @ManyToOne
    private Paciente paciente;

    public Exame() {
    }

    public Exame(Long id, String nome, String descricao, String status, 
            Date tempoEstimado, String resultado, Date dataMarcacao, 
            Recepcionista recepcionista, Paciente paciente) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.tempoEstimado = tempoEstimado;
        this.resultado = resultado;
        this.dataMarcacao = dataMarcacao;
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

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
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
        return Objects.hash(id,nome,descricao,status,tempoEstimado,resultado,
                dataMarcacao);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exame[ id=" + id + " ]";
    }

}
