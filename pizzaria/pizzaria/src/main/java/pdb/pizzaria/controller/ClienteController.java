package pdb.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
        return ResponseEntity.ok("Cliente inserido com sucesso");
    }
}
