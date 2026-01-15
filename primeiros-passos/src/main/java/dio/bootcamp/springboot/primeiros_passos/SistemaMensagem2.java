package dio.bootcamp.springboot.primeiros_passos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.bootcamp.springboot.primeiros_passos.app.Remetente2;

@Component
public class SistemaMensagem2 implements CommandLineRunner {
    
    @Autowired
    private Remetente2 remetente;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem2 enviada por: " + remetente.getNome() + "\nE-mail: " + remetente.getEmail() + "\nCom telefones para contato: " + remetente.getTelefones());
        System.out.println("Seu cadastro2 foi aprovado ...");
    }

}
