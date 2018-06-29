package model.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente", nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "sexo", nullable = false)
    private char sexo;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNascimento;
    
    @Column(name = "cpf", nullable = false)
    private String cpf;
    
    @Column(name = "profissao")
    private String profissao;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "utilizamedicamento")
    private boolean utilizaMedicamento;
    
   @Embedded
    private Endereco endereco;
    
    @JoinTable (name = "paciente_utiliza_medicamento",
            joinColumns = {@JoinColumn(name = "FK_PACIENTE", referencedColumnName = "idPaciente")},
            inverseJoinColumns = {@JoinColumn(name = "FK_MEDICAMENTO", referencedColumnName = "idMedicamento")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medicamento> listaMedicamentos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Exame> exames;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Consulta> consultas;

    public Paciente() {
    }
    
    public Paciente(String nome, char sexo,String telefone, Date dataNascimento, String cpf,
            String profissao, String email, Endereco endereco, boolean utilizaMedicamento) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.profissao = profissao;
        this.email = email;
        this.endereco = endereco;
        this.utilizaMedicamento = utilizaMedicamento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isUtilizaMedicamento() {
        return utilizaMedicamento;
    }

    public void setUtilizaMedicamento(boolean utilizaMedicamento) {
        this.utilizaMedicamento = utilizaMedicamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone, dataNascimento, cpf, profissao, 
                email, utilizaMedicamento);
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
        final Paciente paciente = (Paciente) obj;
        if (!Objects.equals(this.cpf, paciente.cpf)) {
            return false;
        }
        return Objects.equals(this.id, paciente.id);
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone 
                + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", profissao=" 
                + profissao + ", email=" + email + ", utilizaMedicamento=" + utilizaMedicamento 
                + ", endereco=" + endereco + ", medicamentos=" + listaMedicamentos + ", exames=" 
                + exames + ", consultas=" + consultas + '}';
    }

}
