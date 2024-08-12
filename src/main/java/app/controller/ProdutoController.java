package app.controller;

import app.entity.Produto;
import app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Produto produto){
        try {
            String mensagem = this.produtoService.save(produto);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity <String> update (@RequestBody Produto produto, @PathVariable Long id){
        try {
            String mensagem = this.produtoService.update(produto, id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete (@PathVariable Long id){
        try {
            String mensagem = this.produtoService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Produto>> findAll(){
        try {
            List<Produto> lista= this.produtoService.findall();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity <Produto> findById(@PathVariable Long id){
        try {
            Produto produto= this.produtoService.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findTop10ByOrderByPreco")
    public ResponseEntity <List<Produto>> findTop10ByOrderByPreco(){
        try {
            List<Produto> lista= this.produtoService.findTop10ByOrderByPreco();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
