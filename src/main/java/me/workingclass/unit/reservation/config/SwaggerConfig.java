package me.workingclass.unit.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
      .info(new Info()
        .title("API de Reservas")
        .version("1.0")
        .description("API para gerenciamento de reservas de hotel")
        .contact(new Contact()
          .name("Guilherme Santos")
          .url("https://obixy.com.br")
          .email("guilherme.contato080@gmail.com")));
  }

}
