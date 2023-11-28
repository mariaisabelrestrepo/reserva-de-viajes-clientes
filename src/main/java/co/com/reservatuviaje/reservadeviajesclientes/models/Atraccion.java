package co.com.reservatuviaje.reservadeviajesclientes.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name= "atraccion")
@Schema(description = "Atracciones disponibles en los diferentes destinos")
public class Atraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador unico por cada atraccion disponible",example = "345")
    protected Integer id;
    @Schema(description = "Nombre de la atracción", example = "Islas Caiman")
    protected String nombreAtraccion;
}
