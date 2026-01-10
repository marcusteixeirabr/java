package dio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dio.service.SecurityDatabaseService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private SecurityDatabaseService securityDatabaseService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDatabaseService).passwordEncoder(passwordEncoder);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(
                    "/", "/welcome", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/managers/**").hasRole("MANAGERS")
                .requestMatchers("/users/**").hasAnyRole("USERS", "MANAGERS")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            .httpBasic(basic -> {});
        return http.build();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails marcus = User.builder()
            .username("marcus")
            .password(passwordEncoder().encode("minhasenha123"))
            .roles("USERS")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("adminsenha123"))
            .roles("MANAGERS")
            .build();

        return new InMemoryUserDetailsManager(marcus, admin);
    }
    */

}
