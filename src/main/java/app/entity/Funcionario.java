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

public class Funcionario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private int idade;

    private String endereco;

    private String funcao;

    @OneToMany (mappedBy= "funcionario")
    List<Venda> ListaVendas;
}
