package br.com.Bank.Model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios", schema = "cadastrodeusuario")
public class UsuarioEntity {

    @Id
    @SequenceGenerator(name = "id", schema = "cadastrodeusuario", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 120, nullable = false)
    private String nomeCompleto;
    @Column(name = "age", length = 3, nullable = false)
    private Integer idade;
    @Column(name = "rg", length = 9, nullable = false, unique = true)
    private String rg;
    @Column(name = "password", length = 20, nullable = false)
    private String senha;
    @Column(name = "email", length = 80, nullable = false, unique = true)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", idade=" + idade +
                ", rg='" + rg + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
