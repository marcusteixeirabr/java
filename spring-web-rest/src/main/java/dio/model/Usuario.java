package dio.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(length = 50)
    private String nome;
    @Column(length = 20, nullable = false, unique = true)
    private String login;
    @Column(length = 100, nullable = false)
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_role", joinColumns = @JoinColumn(name = "id_user"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    public Usuario() {}

    public Usuario(String login) {
        this.login = login;
    }
    
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() { 
        return "Usuario [id=" + id + ", login=" + login + ", password=" + password + "]";
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

}
