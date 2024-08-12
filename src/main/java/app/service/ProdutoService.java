package app.service;

import app.entity.Produto;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public String save (Produto produto){
        this.produtoRepository.save(produto);
        return "produto salvo com sucesso";
    }

    public  String update (Produto produto, Long id){
        produto.setId(id);
        this.produtoRepository.save(produto);
        return "produto atualizado com sucesso";
    }

    public String delete (Long id){
        this.produtoRepository.deleteById(id);
        return "produto deletado com sucesso";
    }

    public List<Produto> findall(){
        List<Produto> lista= this.produtoRepository.findAll();
        return lista;
    }

    public Produto findById(Long id){
        Produto produto= this.produtoRepository.findById(id).get();
        return produto;
    }

    public List<Produto> findTop10ByOrderByPreco(){
        Pageable pageable = PageRequest.of(0, 10);
        List<Produto> lista= this.produtoRepository.findTop10ByOrderByPreco(pageable);
        return lista;
    }
}
