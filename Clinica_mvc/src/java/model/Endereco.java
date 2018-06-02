package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idEndereco", nullable = false)
    private Long id;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "pais")
    private String pais;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "bairro")
    private String bairro;
    
    @OneToMany(mappedBy = "endereco")
    private List<Paciente> pacientes;

  
    
    public Endereco() {
    }

    public Endereco(Long id, String cidade, String pais, String estado, String rua,
            String complemento, int numero, String bairro) {
        this.id = id;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
    }
    
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Enderecoo[ id=" + id + " ]";
    }

}
