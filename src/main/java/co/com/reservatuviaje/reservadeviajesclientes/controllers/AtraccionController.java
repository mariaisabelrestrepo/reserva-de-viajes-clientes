package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Atraccion;
import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.services.AtraccionService;
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
@RequestMapping("/api/v1/atracciones")
@Tag(name = "Atracciones", description = " Operaciones para agregar y listar atracciones")

public class AtraccionController {

    protected AtraccionService atraccionService;

    @Operation(summary = "Obtener todas las atracciones", description = "Permite ver todas las atracciones existentes")
    @ApiResponse(responseCode = "200", description = "Atracciones obtenidas",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @GetMapping("/getAll")
    public List<Atraccion> verAtracciones() {
        return atraccionService.ObtenerAtracciones();
    }

    @Operation(summary = "Crear atraccion", description = "Permite crear un atraccion")
    @Parameter(name = "Atraccion", description = "Atraccion a crear", content = @Content(schema = @Schema(implementation = Atraccion.class)))

    @ApiResponse(responseCode = "200", description = "Atraccion creada",
            content = @Content(schema = @Schema(implementation = Cliente.class)))
    @PostMapping("/CrearAtraccion")
    public Atraccion crearAtraccion(@RequestBody Atraccion atraccion) {
        return atraccionService.crearAtraccionTuristica(atraccion);
    }


}
