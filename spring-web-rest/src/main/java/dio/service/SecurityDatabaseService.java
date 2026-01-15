package dio.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dio.model.Usuario;
import dio.repository.UsuarioRepository;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuarioEntity = usuarioRepository.findByLogin(login);
        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("User not found with login: " +  login);
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        usuarioEntity.getRoles().forEach(role -> {
            authorities.add(() -> "ROLE_" + role);
        });
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
            usuarioEntity.getLogin(),
            usuarioEntity.getPassword(),
            authorities
        );
        return userDetails;
    }
 
}
