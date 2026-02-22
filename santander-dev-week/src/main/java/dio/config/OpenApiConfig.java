package dio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        // Detecta se está rodando no Railway ou localmente
        String serverUrl = System.getenv("RAILWAY_ENVIRONMENT") != null 
            ? "/" // Railway - usa URL relativa
            : "http://localhost:" + serverPort; // Local - usa localhost com porta

        return new OpenAPI()
                .info(new Info()
                        .title("Santander Dev Week API")
                        .version("1.0.0")
                        .description("RESTful API desenvolvida no bootcamp Santander Dev Week"))
                .servers(List.of(
                        new Server()
                                .url(serverUrl)
                                .description("Servidor Principal")
                ));
    }
}
