package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    protected ClienteService clienteService;

    @GetMapping("/getAll")
    public List<Cliente> verClientes(){
        return clienteService.obtenerTodosLosClientes();
    }

    @PostMapping("/CrearCliente")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }

    @GetMapping(path = "/obtener/{id}")
    public Cliente clientePorId(@PathVariable("id") Integer id){
        return this.clienteService.obtenerClientePorId(id);
    }

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
