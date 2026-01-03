package dio.bootcamp.springboot.primeiros_passos.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner {
    @Autowired
    private Remetente noreply;
    @Autowired
    private Remetente techTeam;

    @Value("${nome:NoReply}")
    private String nome;
    @Value("${email}")
    private String email;
    @Value("${telefones}")
    private List<Long> telefones;

    public void enviarConfirmacaoCadastro() {
        System.out.println(noreply);
        System.out.println("Seu cadastro foi aprovado ...");
    }

    public void enviarMensagemBoasVindas() {
        techTeam.setEmail("techteam@example.com");
        System.out.println(techTeam);
        System.out.println("Seja bem-vindo(a) a Tech Elite ...");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: " + nome + "\nE-mail: " + email + "\nCom telefones para contato: " + telefones);
        System.out.println("Seu cadastro foi aprovado ...");
    }

    
}
