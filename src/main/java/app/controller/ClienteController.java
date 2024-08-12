package app.controller;

import app.entity.Cliente;
import app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Cliente cliente){
        try {
            String mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity <String> update (@RequestBody Cliente cliente, @PathVariable Long id){
        try {
            String mensagem = this.clienteService.update(cliente, id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete (@PathVariable Long id){
        try {
            String mensagem = this.clienteService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Cliente>> findAll(){
        try {
            List<Cliente> lista= this.clienteService.findall();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity <Cliente> findById(@PathVariable Long id){
        try {
            Cliente cliente= this.clienteService.findById(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/findClientesByIdadeBetween18And35")
    public ResponseEntity <List<Cliente>> findClientesByIdadeBetween18And35(){
        try {
            List<Cliente> lista= this.clienteService.findClientesByIdadeBetween18And35();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

}
