package dio.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    private Contact contato() {
        Contact contact = new Contact();
        contact.setName("Seu nome");
        contact.setUrl("https://www.seusite.com.br");
        contact.setEmail("voce@seusite.com.br");
        return contact;
    }

    private License licenca() {
        License license = new License();
        license.setName("Licença - sua Empresa");
        license.setUrl("http://www.seusite.com.br");
        return license;
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title - Rest API")
                        .description("API exemplo de uso do Swagger com Spring Boot Rest API")
                        .version("1.0")
                        .termsOfService("Termos de uso: Open Source")
                        .contact(this.contato())
                        .license(this.licenca()));
    }
}
