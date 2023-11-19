package co.com.reservatuviaje.reservadeviajesclientes.services;

import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.repositories.ClientesRepository;
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
public class ClienteService {

    protected ClientesRepository clientesRepository;

    public Cliente crearCliente(Cliente cliente) {
        try {
            return clientesRepository.save(cliente);
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error creando el cliente", e);
            return null;
        }
    }

    public Cliente obtenerClientePorId(Integer id) {
        try {
            return clientesRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error al consultar el cliente por ID", e);
            return null;
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        try {
            return clientesRepository.findAll();
        } catch (DataAccessException e) {
            logErrorAndThrowException("Error al buscar todos los clientes", e);
            return null;
        }
    }
    public boolean eliminarCliente(Integer id) {
        clientesRepository.deleteById(id);
        if (clientesRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

    private void logErrorAndThrowException(String message, Exception e) {
        log.error(message, e);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message, e);
    }
}
