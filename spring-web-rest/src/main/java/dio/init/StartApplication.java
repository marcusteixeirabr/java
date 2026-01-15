package dio.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dio.model.Usuario;
import dio.service.UsuarioService;
import jakarta.transaction.Transactional;

@Component
public class StartApplication implements CommandLineRunner{

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Usuario user = usuarioService.getByLogin("admin");
        if (user == null) {
            Usuario admin = new Usuario("admin", passwordEncoder.encode("admin123"));
            admin.setNome("Administrador");
            admin.getRoles().add("MANAGERS");
            usuarioService.save(admin);
        }

        user = usuarioService.getByLogin("user");
        if (user == null) {
            Usuario normalUser = new Usuario("user", passwordEncoder.encode("user123"));
            normalUser.setNome("Usuário Comum");
            normalUser.getRoles().add("USERS");
            usuarioService.save(normalUser);
        }
    }

}
