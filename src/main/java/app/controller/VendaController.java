package app.controller;

import app.entity.Cliente;
import app.entity.Funcionario;
import app.entity.Produto;
import app.entity.Venda;
import app.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Venda venda){
        try {
            String mensagem = this.vendaService.save(venda);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity <String> update (@RequestBody Venda venda, @PathVariable Long id){
        try {
            String mensagem = this.vendaService.update(venda, id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete (@PathVariable Long id){
        try {
            String mensagem = this.vendaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Venda>> findAll(){
        try {
            List<Venda> lista= this.vendaService.findall();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity <Venda> findById(@PathVariable Long id){
        try {
            Venda venda= this.vendaService.findById(id);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/Calcualar")
    public ResponseEntity <Double> calcularVenda (@RequestBody List<Produto> produtos){
        try {
            double total= this.vendaService.calcularVenda(produtos);
            return new ResponseEntity<>(total, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findByClienteNome")
    public ResponseEntity <List<Venda>> findByClienteNome(@RequestBody String cliente){
        try {
            List<Venda> lista= this.vendaService.findByClienteNome(cliente);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findByFuncionarioNome")
    public ResponseEntity <List<Venda>> findByFuncionarioNome(String funcionario){
        try {
            List<Venda> lista= this.vendaService.findByFuncionarioNome(funcionario);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findTop10VendasByTotal")
    public ResponseEntity <List<Venda>> findTop10VendasByTotal(){
        try {
            List<Venda> lista= this.vendaService.findTop10VendasByTotal();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

}
