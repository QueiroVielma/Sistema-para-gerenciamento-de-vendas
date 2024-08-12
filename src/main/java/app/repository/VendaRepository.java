package app.repository;

import app.entity.Venda;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT v FROM Venda v WHERE LOWER(v.cliente.nome) LIKE LOWER(CONCAT('%', :nomeCliente, '%'))")
    List<Venda> findByClienteNome(@Param("nomeCliente") String nomeCliente);

    @Query("SELECT v FROM Venda v WHERE LOWER(v.funcionario.nome) LIKE LOWER(CONCAT('%', :nomeFuncionario, '%'))")
    List<Venda> findByFuncionarioNome(@Param("nomeFuncionario") String nomeFuncionario);

    @Query("SELECT v FROM Venda v ORDER BY v.total DESC")
    List<Venda> findTop10VendasByTotal(Pageable pageable);
}
