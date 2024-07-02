package pdb.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pdb.pizzaria.model.Cliente;
import pdb.pizzaria.model.Pedido;
import pdb.pizzaria.repository.ClienteRepository;
import pdb.pizzaria.repository.PedidoRepository;

@RestController
@CrossOrigin("*")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/api/pedido")
    public ResponseEntity<String> inserir(@RequestBody Pedido pedido){
        if (pedido.getCliente() != null && pedido.getCliente().getId() != 0) {
            Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                                               .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            pedido.setCliente(cliente);
        }
        repository.save(pedido);
        String msg = "Pedido inserido com sucesso";
        return ResponseEntity.ok(msg);
    }
    
}
