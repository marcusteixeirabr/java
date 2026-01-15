package dio.bootcamp.springboot.primeiros_passos.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;


@Configuration
public class Beans {
    @Bean
	public Gson gson() {
		return new Gson();
	}

    @Bean
    @Scope("prototype")
    public Remetente remetente() {
        System.out.println("CRIANDO UM REMETENTE ...");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@example.com");
        remetente.setNome("Digital Innovation One");
        return remetente;        
    }
}
