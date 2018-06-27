package model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atestado")
public class Atestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtestado", nullable = false)
    private Long id;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @JoinColumn(name = "idConsulta", referencedColumnName = "idConsulta")
    @ManyToOne
    private Consulta consulta;
    
    public Atestado() {
    }

    public Atestado(Long id, String tipo, String descricao, Consulta consulta) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.consulta = consulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, descricao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(Atestado.class == obj.getClass())) {
            return false;
        }
        Atestado ats = (Atestado) obj;
        if (!Objects.equals(this.tipo, ats.tipo)) {
            return false;
        }
        return Objects.equals(this.id, ats.id);
    }

    @Override
    public String toString() {
        return "Atestado{" + "id=" + id + ", tipo=" + tipo + ", descricao=" 
                + descricao + ", consulta=" + consulta + '}';
    }
    
}
