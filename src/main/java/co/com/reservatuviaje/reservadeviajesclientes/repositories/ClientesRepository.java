package co.com.reservatuviaje.reservadeviajesclientes.repositories;


import co.com.reservatuviaje.reservadeviajesclientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository <Cliente,Integer>{
}
