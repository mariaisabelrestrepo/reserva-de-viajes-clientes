package co.com.reservatuviaje.reservadeviajesclientes.controllers;

import co.com.reservatuviaje.reservadeviajesclientes.models.Atraccion;
import co.com.reservatuviaje.reservadeviajesclientes.services.AtraccionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/atracciones")
public class AtraccionController {

    protected AtraccionService atraccionService;

    @GetMapping("/getAll")
    public List<Atraccion> verAtracciones() {
        return atraccionService.ObtenerAtracciones();
    }

    @PostMapping("/CrearAtraccion")
    public Atraccion crearAtraccion(@RequestBody Atraccion atraccion) {
        return atraccionService.crearAtraccionTuristica(atraccion);
    }


}
