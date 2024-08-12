package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opservacoes;

    private Double total;

    @ManyToOne (cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne (cascade = CascadeType.ALL)
    private Funcionario funcionario;

    @ManyToMany
    @JoinTable(
            name = "venda_produtos",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

}
