package model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
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
    
    public Endereco() {
    }

    public Endereco(String cidade, String pais, String estado, String rua,
            String complemento, int numero, String bairro) {
        
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
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

    @Override
    public int hashCode() {
        return Objects.hash(cidade,pais,estado,rua,complemento,numero,bairro);
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
        final Endereco endereco = (Endereco) obj;
        if (this.numero != endereco.numero) {
            return false;
        }
        if (!Objects.equals(this.cidade, endereco.cidade)) {
            return false;
        }
        if (!Objects.equals(this.pais, endereco.pais)) {
            return false;
        }
        if (!Objects.equals(this.estado, endereco.estado)) {
            return false;
        }
        if (!Objects.equals(this.rua, endereco.rua)) {
            return false;
        }
        if (!Objects.equals(this.complemento, endereco.complemento)) {
            return false;
        }
        return Objects.equals(this.bairro, endereco.bairro);
    }

    @Override
    public String toString() {
        return "Endereco{" + "cidade=" + cidade + ", pais=" + pais + ", estado=" 
                + estado + ", rua=" + rua + ", complemento=" + complemento + ", numero=" 
                + numero + ", bairro=" + bairro + '}';
    }
    
}
