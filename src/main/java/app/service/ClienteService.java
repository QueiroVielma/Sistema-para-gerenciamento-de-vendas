package app.service;

import app.entity.Cliente;
import app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public String save (Cliente cliente){
        this.clienteRepository.save(cliente);
        return "cliente salvo com sucesso";
    }

    public  String update (Cliente cliente, Long id){
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return "cliente atualizado com sucesso";
    }

    public String delete (Long id){
        this.clienteRepository.deleteById(id);
        return "cliente deletado com sucesso";
    }

    public List<Cliente> findall(){
        List<Cliente> lista= this.clienteRepository.findAll();
        return lista;
    }

    public Cliente findById(Long id){
        Cliente cliente= this.clienteRepository.findById(id).get();
        return cliente;
    }

    public List<Cliente> findClientesByIdadeBetween18And35(){
        List<Cliente> lista= this.clienteRepository.findClientesByIdadeBetween18And35();
        return lista;
    }




}
