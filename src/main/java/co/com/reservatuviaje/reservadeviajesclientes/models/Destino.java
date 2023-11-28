package co.com.reservatuviaje.reservadeviajesclientes.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "destino")
@Schema(description = "Destinos disponibles para viajar ")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador unico por cada destino disponible", example = "362")
    protected Integer id;
    @Schema(description = "Nombre del destino registrado",example = "Cartagena")
    protected String nombreDestino;
    @Schema(description = "Descripcion del destino registrado",example = "Ofrece vistas maravillosas")
    protected String descripcion;
    @Schema(description = "Puntuacion asignada al destino",example = "5.0")
    protected String puntuacion;
    @Schema(description = "Atraccion destacada del destino",example = "Castillo de San Felipe")
    protected Integer atraccion;


}
