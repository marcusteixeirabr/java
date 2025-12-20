package dio;

import java.time.LocalDateTime;

public class Pessoa {

    private String nome;
    private LocalDateTime nascimento;

    public Pessoa(String nome, LocalDateTime nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return LocalDateTime.now().getYear() - nascimento.getYear();
    }

    public boolean ehMaiorDeIdade() {
        return getIdade() >= 18;
    }

}
