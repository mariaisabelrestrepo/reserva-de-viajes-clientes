package co.com.reservatuviaje.reservadeviajesclientes.models;

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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String tipoDocumento;
    protected String nroDocumento;
    protected String direccion;
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
