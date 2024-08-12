package app.service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public String save (Funcionario funcionario){
        this.funcionarioRepository.save(funcionario);
        return "Funcionario salvo com sucesso";
    }

    public  String update (Funcionario funcionario, Long id){
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return "Funcionario atualizado com sucesso";
    }

    public String delete (Long id){
        this.funcionarioRepository.deleteById(id);
        return "Funcionario deletado com sucesso";
    }

    public List<Funcionario> findall(){
        List<Funcionario> lista= this.funcionarioRepository.findAll();
        return lista;
    }

    public Funcionario findById(Long id){
        Funcionario funcionario= this.funcionarioRepository.findById(id).get();
        return funcionario;
    }
}
