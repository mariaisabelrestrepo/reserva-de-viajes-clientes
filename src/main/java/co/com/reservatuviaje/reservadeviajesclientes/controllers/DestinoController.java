package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Destino;
import co.com.reservatuviaje.reservadeviajesclientes.services.DestinoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/destinos")
public class DestinoController {

   protected DestinoService destinoService;

    @GetMapping("/getAll")
    public List<Destino> verTodosLosDestinos(){
        return destinoService.obtenerTodosLosDestinos();
    }

    @PostMapping("/CrearDestino")
    public Destino crearDestino(@RequestBody Destino destino){
        return destinoService.crearDestino(destino);
    }

    @DeleteMapping (path= "/Eliminar/{id}")
    public String DeleteDestino(@PathVariable("id") Integer id){
        boolean respuesta= this.destinoService.eliminarDestino(id);
        if (respuesta){
            return "Se elimino el destino con id " +id;
        }
        else{

            return "No se pudo eliminar el destino con id "+id;
        }

    }

}
