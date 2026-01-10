package dio.controller;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String home() {
        return "Bem-vindo! Acesse /welcome, /users ou /managers";
    }
    
    @GetMapping("/welcome")
    public String welcome() {
    return "Welcome to Spring Boot with Java!";
    }
    @GetMapping("/users")
    //@PreAuthorize("hasAnyRole('USERS','MANAGERS')")
    public String users() {
        return "Usuário Autorizado!";
    }
    @GetMapping("/managers")
    //@PreAuthorize("hasRole('MANAGERS')")
    public String managers() {
        return "Gerente Autorizado!";
    }

}
