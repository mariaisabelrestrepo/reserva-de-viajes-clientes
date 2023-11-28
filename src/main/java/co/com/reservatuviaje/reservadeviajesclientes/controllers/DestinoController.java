package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.models.Destino;
import co.com.reservatuviaje.reservadeviajesclientes.services.DestinoService;
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
@RequestMapping("/api/v1/destinos")
@Tag(name = "Destinos", description = " Operaciones para interactuar con los destinos disponibles en la aplicacion")

public class DestinoController {

   protected DestinoService destinoService;

    @Operation(summary = "Consultar todos los destinos", description = "Permite ver todos los destinos registrados")
    @ApiResponse(responseCode = "200", description = "Destinos obtenidos",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @GetMapping("/getAll")
    public List<Destino> verTodosLosDestinos(){
        return destinoService.obtenerTodosLosDestinos();
    }

    @Operation(summary = "Crear un destino", description = "Permite crear un destino")
    @Parameter(name = "Destino", description = "Destino a crear", content = @Content(schema = @Schema(implementation = Destino.class)))
    @ApiResponse(responseCode = "200", description = "Destino creado",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @PostMapping("/CrearDestino")
    public Destino crearDestino(@RequestBody Destino destino){
        return destinoService.crearDestino(destino);
    }

    @Operation(summary = "Eliminar un destino", description = "Permite eliminar un destino")
    @ApiResponse(responseCode = "200", description = "Destino eliminado",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
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
