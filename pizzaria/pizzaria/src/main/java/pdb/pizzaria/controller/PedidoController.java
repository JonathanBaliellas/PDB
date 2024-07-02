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
import pdb.pizzaria.model.Entrega;
import pdb.pizzaria.model.Pedido;
import pdb.pizzaria.repository.ClienteRepository;
import pdb.pizzaria.repository.EntregaRepository;
import pdb.pizzaria.repository.PedidoRepository;

@RestController
@CrossOrigin("*")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private EntregaRepository entregaRepo;

    @PostMapping("/api/pedido")
    public ResponseEntity<String> inserir(@RequestBody Pedido pedido){
        if (pedido.getCliente() != null && pedido.getCliente().getId() != 0) {
            Cliente cliente = clienteRepo.findById(pedido.getCliente().getId())
                                               .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            pedido.setCliente(cliente);
        }
        if (pedido.getEntrega() != null && pedido.getEntrega().getId() != 0) {
            Entrega entrega = entregaRepo.findById(pedido.getEntrega().getId())
                                               .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
            pedido.setEntrega(entrega);
        }
        pedidoRepo.save(pedido);
        String msg = "Pedido inserido com sucesso";
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/api/pedido")
    public ResponseEntity<String> atualizar(@RequestBody Pedido pedido){
        pedido.getItensPedido().clear();
        pedidoRepo.save(pedido);
        String msg = "Pedido atualizado com sucesso";
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/api/pedido/{id}")
    public ResponseEntity<Pedido> consultar(@PathVariable long id){
        Optional<Pedido> pedido = pedidoRepo.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.ok(new Pedido());
        }
    }
    @GetMapping("/api/pedido/lista/{cliente_id}")
    public ResponseEntity<List<Pedido>> listar(@PathVariable long cliente_id){
        List<Pedido> lista = pedidoRepo.findByCliente(cliente_id);
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/pedido/{id}")
    public ResponseEntity<String> excluir(@PathVariable long id){
        pedidoRepo.deleteById(id);
        String msg = "Pedido excluído com sucesso";
        return ResponseEntity.ok(msg);
    }
}
