package app.repository;

import app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.idade BETWEEN 18 AND 35")
    List<Cliente> findClientesByIdadeBetween18And35();


}
