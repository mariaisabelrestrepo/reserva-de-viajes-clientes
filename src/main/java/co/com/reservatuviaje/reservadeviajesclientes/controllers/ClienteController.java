package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = " Operaciones de los clientes que se registran en el aplicativo reserva de viajes")
public class ClienteController {

    protected ClienteService clienteService;

    @Operation(summary = "Obtener todos los clientes", description = "Permite ver todos los clientes registrados")
    @ApiResponse(responseCode = "200", description = "Clientes obtenidos",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @GetMapping("/getAll")
    public List<Cliente> verClientes(){
        return clienteService.obtenerTodosLosClientes();
    }


    @Operation(summary = "Crear cliente nuevo", description = "Permite registrar un nuevo cliente")
    @Parameter(name = "Cliente", description = "Cliente a crear", content = @Content(schema = @Schema(implementation = Cliente.class)))
    @ApiResponse(responseCode = "200", description = "Cliente creado",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @PostMapping("/CrearCliente")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }


    @Operation(summary = "Obtener un cliente por Id", description = "Permite ver un cliente por su id")
    @ApiResponse(responseCode = "200", description = "Cliente obtenido",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @GetMapping(path = "/obtener/{id}")
    public Cliente clientePorId(@PathVariable("id") Integer id){
        return this.clienteService.obtenerClientePorId(id);
    }


    @Operation(summary = "Actualizar un cliente", description = "Permite modificar un cliente por id")
    @Parameter(name = "cliente", description = "Clientes a listar", content = @Content(schema = @Schema(implementation = Cliente.class)))
    @ApiResponse(responseCode = "200", description = "Clientes obtenidos",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @PatchMapping("/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente){
        Cliente cliente1= clienteService.obtenerClientePorId(id);
        cliente1.setNombres(cliente.getNombres());
        cliente1.setDireccion(cliente.getDireccion());
        cliente1.setTelefono(cliente.getTelefono());
        cliente1.setApellidos(cliente.getApellidos());
        cliente1.setCorreo(cliente.getCorreo());
        cliente1.setTipoDocumento(cliente.getTipoDocumento());
        cliente1.setNroDocumento(cliente.getNroDocumento());
        return clienteService.crearCliente(cliente1);

    }

    @Operation(summary = "Eliminar un cliente", description = "Permite eliminar un cliente registrado")
    @ApiResponse(responseCode = "200", description = "Cliente eliminado",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @DeleteMapping (path= "/Eliminar/{id}")
    public String DeleteCliente(@PathVariable("id") Integer id){
        boolean respuesta= this.clienteService.eliminarCliente(id);
        if (respuesta){
            return "Se elimino el cliente con id " +id;
        }
        else{

            return "No se pudo eliminar el cliente con id "+id;
        }

    }

}
