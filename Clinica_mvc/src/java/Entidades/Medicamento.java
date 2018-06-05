package Entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedicamento", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "via")
    private String via;
    
    @Column(name = "dose")
    private String dose;
    
    @Column(name = "intervalo")
    private String intervalo;
    
    @Column(name = "tempo_de_uso")
    private int tempoDeUso;
    
    @ManyToMany(mappedBy = "medicamentos")
    private List<Paciente> pacientes;
    
    @ManyToMany(mappedBy = "medicamentos")
    private List<Resposta> respostas;

    public Medicamento() {
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Medicamento(Long id, String nome, String via, String dose, String intervalo, int tempoDeUso) {
        this.id = id;
        this.nome = nome;
        this.via = via;
        this.dose = dose;
        this.intervalo = intervalo;
        this.tempoDeUso = tempoDeUso;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public int getTempoDeUso() {
        return tempoDeUso;
    }

    public void setTempoDeUso(int tempoDeUso) {
        this.tempoDeUso = tempoDeUso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nome,via,dose,intervalo,tempoDeUso);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Medicamentoo[ id=" + id + " ]";
    }

}
