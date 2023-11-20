package co.com.reservatuviaje.reservadeviajesclientes.services;

import co.com.reservatuviaje.reservadeviajesclientes.models.Destino;
import co.com.reservatuviaje.reservadeviajesclientes.repositories.DestinoRepository;
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
public class DestinoService {

    protected DestinoRepository destinoRepository;

    public Destino crearDestino(Destino destino) {
        try {
            return destinoRepository.save(destino);
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error creando destino", e);
            return null;
        }
    }
    public List<Destino> obtenerTodosLosDestinos() {
        try {
            return destinoRepository.findAll();
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error al buscar todos los destinos", e);
            return null;
        }
    }
    public boolean eliminarDestino(Integer id) {
        destinoRepository.deleteById(id);
        if (destinoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

    private void logErrorAndThrowException(String message, Exception e) {
        log.error(message, e);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message, e);
    }
}
