package co.com.reservatuviaje.reservadeviajesclientes;

import co.com.reservatuviaje.reservadeviajesclientes.controllers.ClienteController;
import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import co.com.reservatuviaje.reservadeviajesclientes.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ReservaDeViajesClientesApplicationTests {

    @InjectMocks
    private ClienteController clienteController;
    @Mock
    private ClienteService clienteService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void verClientes_DeberiaRetornarListaClientes() {
        Cliente cliente1 = new Cliente(1,"Juan","perez","prueba@gmail","CC","234567","Las vegas","45172384");
        Cliente cliente2 = new Cliente(2,"Andrea Carolina","Gomez","Andrea@gmail","CC","1002735664","Cra 22 #12","34");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        when(clienteService.obtenerTodosLosClientes()).thenReturn(clientes);
        List<Cliente> resultado = clienteController.verClientes();

        assertThat(resultado).isNotNull();
        assertThat(resultado).hasSize(2);
    }

    @Test
    public void crearCliente_DeberiaRetornarClienteCreado() {
        Cliente clienteEntrada = new Cliente(1,"Juan","perez","prueba@gmail","CC","234567","Las vegas","45172384");
        Cliente clienteCreado = new Cliente(1,"Juan","perez","prueba@gmail","CC","234567","Las vegas","45172384");

        when(clienteService.crearCliente(any(Cliente.class))).thenReturn(clienteCreado);

        Cliente resultado = clienteController.crearCliente(clienteEntrada);

        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(clienteCreado);
    }

    @Test
    public void clientePorId_DeberiaRetornarClienteExistente() {
        // Arrange
        Integer id = 1;
        Cliente clienteExistente = new Cliente(1,"Juan","perez","prueba@gmail","CC","234567","Las vegas","45172384");

        when(clienteService.obtenerClientePorId(id)).thenReturn(clienteExistente);

        // Act
        Cliente resultado = clienteController.clientePorId(id);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(clienteExistente);
    }

    @Test
    public void actualizarCliente_DeberiaRetornarClienteActualizado() {
        // Arrange
        Integer id = 1;
        Cliente clienteEntrada = new Cliente(1,"Juan","Sanchez","prueba@gmail","CC","234567","Las vegas","45172384");
        Cliente clienteExistente = new Cliente(1,"Juan","perez","prueba@gmail","CC","234567","Las vegas","45172384");

        when(clienteService.obtenerClientePorId(id)).thenReturn(clienteExistente);
        when(clienteService.crearCliente(any(Cliente.class))).thenReturn(clienteExistente);

        // Act
        Cliente resultado = clienteController.actualizarCliente(id, clienteEntrada);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado).isEqualTo(clienteExistente);
    }

    @Test
    public void DeleteCliente_DeberiaRetornarMensajeEliminacionExitosa() {
        // Arrange
        Integer id = 1;
        when(clienteService.eliminarCliente(id)).thenReturn(true);

        // Act
        String resultado = clienteController.DeleteCliente(id);

        // Assert
        assertThat(resultado).isEqualTo("Se elimino el cliente con id " + id);
    }

    @Test
    public void DeleteCliente_DeberiaRetornarMensajeFalloEliminacion() {
        // Arrange
        Integer id = 1;
        when(clienteService.eliminarCliente(id)).thenReturn(false);

        // Act
        String resultado = clienteController.DeleteCliente(id);

        // Assert
        assertThat(resultado).isEqualTo("No se pudo eliminar el cliente con id " + id);
    }


}
