package dio.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Parses DATABASE_URL from Railway and extracts components for Spring DataSource configuration.
 * Railway provides: postgresql://user:password@host:port/database
 * PostgreSQL JDBC driver requires: jdbc:postgresql://host:port/database with separate username/password
 */
@Component
public class DatabaseUrlParser implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String databaseUrl = environment.getProperty("DATABASE_URL");
        
        if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            try {
                // Parse the Railway DATABASE_URL format
                URI uri = new URI("postgresql" + databaseUrl.substring("postgresql".length()));
                
                String host = uri.getHost();
                int port = uri.getPort();
                String database = uri.getPath().substring(1); // Remove leading /
                String username = uri.getUserInfo().split(":")[0];
                String password = uri.getUserInfo().split(":")[1];
                
                // Build proper JDBC URL
                String jdbcUrl = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
                
                // Add properties for Spring DataSource
                Map<String, Object> props = new HashMap<>();
                props.put("spring.datasource.url", jdbcUrl);
                props.put("spring.datasource.username", username);
                props.put("spring.datasource.password", password);
                props.put("spring.datasource.driver-class-name", "org.postgresql.Driver");
                
                MapPropertySource propertySource = new MapPropertySource("DatabaseUrlParser", props);
                environment.getPropertySources().addFirst(propertySource);
                
            } catch (URISyntaxException e) {
                System.err.println("Failed to parse DATABASE_URL: " + e.getMessage());
            }
        }
    }
}
