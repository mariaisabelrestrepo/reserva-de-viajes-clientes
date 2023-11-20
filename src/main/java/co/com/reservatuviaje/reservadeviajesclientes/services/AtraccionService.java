package co.com.reservatuviaje.reservadeviajesclientes.services;

import co.com.reservatuviaje.reservadeviajesclientes.models.Atraccion;
import co.com.reservatuviaje.reservadeviajesclientes.repositories.AtraccionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class AtraccionService {

    protected AtraccionRepository atraccionRepository;

    public Atraccion crearAtraccionTuristica(Atraccion atraccion ) {
        try {
            return atraccionRepository.save(atraccion);
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error creando atraccion", e);
            return null;
        }
    }

    public List<Atraccion> ObtenerAtracciones() {
        try {
            return atraccionRepository.findAll();
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error al buscar todas las transacciones existentes", e);
            return null;
        }
    }

    private void logErrorAndThrowException(String message, Exception e) {
        log.error(message, e);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message, e);
    }
}
