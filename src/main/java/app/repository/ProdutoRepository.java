package app.repository;

import app.entity.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> findTop10ByOrderByPreco(Pageable pageable);
}
