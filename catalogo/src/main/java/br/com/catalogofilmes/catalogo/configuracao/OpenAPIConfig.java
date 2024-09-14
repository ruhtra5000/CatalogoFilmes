package br.com.catalogofilmes.catalogo.configuracao;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI configuracaoOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("Catalogo de Filmes")
                .version("1.0")
                .description("Uma simples API de catálogo de filmes")
                .contact(new Contact()
                    .name("Arthur de Sá Tenório")
                    .email("arthur.sat@ufape.edu.br")
                )
                //.license(new License())...
            )
            .servers(Arrays.asList(new Server().url("http://localhost:8080")));
    }
}
