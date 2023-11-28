package co.com.reservatuviaje.reservadeviajesclientes.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
@Schema(description = "Cliente general que accede al sistema de reserva de viajes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador unico por cliente",example = "635")
    protected Integer id;
    @Schema(description = "Nombres del cliente",example = "Andrés Julian")
    protected String nombres;
    @Schema(description = "Apellidos del cliente", example= "Roldan Gomez")
    protected String apellidos;
    @Schema(description = "Correo del cliente registrado", example= "Andres@hotmail.com")
    protected String correo;
    @Schema(description = "Tipo de documento del cliente", example= "CC")
    protected String tipoDocumento;
    @Schema(description = "Numero de documento del cliente", example= "1095728432")
    protected String nroDocumento;
    @Schema(description = "Direccion del cliente", example= "Carrera 34 # 12-15")
    protected String direccion;
    @Schema(description = "Telefono del cliente", example= "3256728240")
    protected String telefono;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nroDocumento='" + nroDocumento + '\'' +
                '}';
    }

}
