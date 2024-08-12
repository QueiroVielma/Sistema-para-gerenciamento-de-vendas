package app.service;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service

public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    public String save (Venda venda){
        double totalVenda =calcularVenda(venda.getProdutos());
        venda.setTotal(totalVenda);
        this.vendaRepository.save(venda);
        return "Venda salvo com sucesso";
    }

    public  String update (Venda venda, Long id){
        venda.setId(id);
        this.vendaRepository.save(venda);
        return "Venda atualizado com sucesso";
    }

    public String delete (Long id){
        this.vendaRepository.deleteById(id);
        return "Venda deletado com sucesso";
    }

    public List<Venda> findall(){
        List<Venda> lista= this.vendaRepository.findAll();
        return lista;
    }

    public Venda findById(Long id){
        Venda carro= this.vendaRepository.findById(id).get();
        return carro;
    }

    public double calcularVenda(List<Produto> produtos) {

        double totalVenda=0;

        for (Produto produto : produtos){
           totalVenda+=produto.getPreco();
        }

        return totalVenda;
    }

    public List<Venda> findByClienteNome(String cliente){
        List<Venda> lista= this.vendaRepository.findByClienteNome( cliente);
        return lista;
    }

    public List<Venda> findByFuncionarioNome(String funcionario){
        List<Venda> lista= this.vendaRepository.findByFuncionarioNome(funcionario);
        return lista;
    }

    public List<Venda> findTop10VendasByTotal(){
        Pageable pageable = PageRequest.of(0, 10);
        List<Venda> lista= this.vendaRepository.findTop10VendasByTotal(pageable);
        return lista;
    }

}
