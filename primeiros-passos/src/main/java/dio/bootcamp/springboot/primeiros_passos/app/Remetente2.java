package dio.bootcamp.springboot.primeiros_passos.app;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "remetente")
public class Remetente2 {
    private String nome;
    private String email;
    private List<Long> telefones;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Long> getTelefones() { return telefones; }
    public void setTelefones(List<Long> telefones) { this.telefones = telefones; }

    @Override
    public String toString() {
        return "Remetente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
