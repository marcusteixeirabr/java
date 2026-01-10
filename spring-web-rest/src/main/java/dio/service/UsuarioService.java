package dio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.handler.CampoObrigatorioException;
import dio.model.Usuario;
import dio.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        System.out.println("LIST - Listando os usuários do sistema");
        return repository.findAll();
    }

    public Usuario getByLogin(String login) {
        System.out.println(String.format("FIND/login - Buscando usuário com login: %s", login));
        return repository.findByLogin(login);
    }

    public Usuario getById(Integer id) {
        System.out.println(String.format("FIND/id - Buscando usuário com id: %d", id));
        return repository.findById(id).orElse(null);
    }

    public void save(Usuario usuario) {
        if (usuario.getLogin() == null) {
            throw new CampoObrigatorioException("login");
        }

        if (usuario.getPassword() == null) {
            throw new CampoObrigatorioException("password");
        }

        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de serviço");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de serviço");
        }
        System.out.println(usuario);
        repository.save(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        repository.deleteById(id);
    }

}
