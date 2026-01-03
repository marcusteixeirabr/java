package dio.bootcamp.springboot.primeiros_passos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem {
    @Autowired
    private Remetente noreply;
    @Autowired
    private Remetente techTeam;

    public void enviarConfirmacaoCadastro() {
        System.out.println(noreply);
        System.out.println("Seu cadastro foi aprovado ...");
    }

    public void enviarMensagemBoasVindas() {
        techTeam.setEmail("techteam@example.com");
        System.out.println(techTeam);
        System.out.println("Seja bem-vindo(a) a Tech Elite ...");
    }
}
