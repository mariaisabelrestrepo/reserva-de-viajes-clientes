package co.com.reservatuviaje.reservadeviajesclientes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio reserva de viajes ", version = "1.0",
        description = "API que expone los endpoints para las entidades atracciones, destinos y usuarios"))
public class SwaggerConfig {
}
