package dio.controller;

import org.springframework.web.bind.annotation.RestController;

import dio.model.Usuario;
import dio.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public List<Usuario> getUsuarios() {
        return service.getAll();
    }
    
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return service.getByLogin(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @PostMapping()
    public void postUsuario(@RequestBody Usuario usuario) {
        service.save(usuario);
    }

    @PutMapping()
    public void putUsuario(@RequestBody Usuario usuario) {
        service.save(usuario);
    }

}
