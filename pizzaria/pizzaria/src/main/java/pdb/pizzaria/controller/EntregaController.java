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

import pdb.pizzaria.model.Entrega;
import pdb.pizzaria.repository.EntregaRepository;

@RestController
@CrossOrigin("*")
public class EntregaController {
    @Autowired
    EntregaRepository entregaRepo;

    @PostMapping("/api/entrega")
    public ResponseEntity<String> inserir(@RequestBody Entrega entrega){
        entregaRepo.save(entrega);
        String msg = "Entrega inserido com sucesso";
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/api/entrega")
    public ResponseEntity<String> atualizar(@RequestBody Entrega entrega){
        entregaRepo.save(entrega);
        String msg = "Entrega atualizado com sucesso";
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/api/entrega/{id}")
    public ResponseEntity<Entrega> consultar(@PathVariable long id){
        Optional<Entrega> entrega = entregaRepo.findById(id);
        if (entrega.isPresent()) {
            return ResponseEntity.ok(entrega.get());
        } else {
            return ResponseEntity.ok(new Entrega());
        }
    }
    @GetMapping("/api/entrega/lista")
    public ResponseEntity<List<Entrega>> listar(){
        List<Entrega> lista = entregaRepo.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/entrega/{id}")
    public ResponseEntity<String> excluir(@PathVariable long id){
        entregaRepo.deleteById(id);
        String msg = "Entrega excluída com sucesso";
        return ResponseEntity.ok(msg);
    }
}
