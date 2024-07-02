package pdb.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pdb.pizzaria.model.Cliente;
import pdb.pizzaria.repository.ClienteRepository;

@RestController
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    @PostMapping("/api/cliente")
    public ResponseEntity<String> inserir(@RequestBody Cliente cliente){
        repository.save(cliente);
        String msg = "Cliente inserido com sucesso";
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/api/cliente")
    public ResponseEntity<String> atualizar(@RequestBody Cliente cliente){
        repository.save(cliente);
        String msg = "Cliente atualizado com sucesso";
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/api/cliente/{id}")
    public ResponseEntity<Cliente> consultar(@PathVariable long id){
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.ok(new Cliente());
        }
    }
    @GetMapping("/api/cliente/lista")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cliente/{id}")
    public ResponseEntity<String> excluir(@PathVariable long id){
        repository.deleteById(id);
        String msg = "Cliente excluído com sucesso";
        return ResponseEntity.ok(msg);
    }
}
