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

import pdb.pizzaria.model.ItemPedido;
import pdb.pizzaria.model.Pedido;
import pdb.pizzaria.repository.ItemPedidoRepository;
import pdb.pizzaria.repository.PedidoRepository;

@RestController
@CrossOrigin("*")
public class ItemPedidoController {
    @Autowired
    ItemPedidoRepository itemPedidoRepo;

    @Autowired
    PedidoRepository pedidoRepo;

    @PostMapping("/api/item-pedido")
    public ResponseEntity<String> inserir(@RequestBody ItemPedido item){
        if (item.getPedido() != null && item.getPedido().getId() != 0) {
            Pedido pedido = pedidoRepo.findById(item.getPedido().getId())
                                               .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
            item.setPedido(pedido);
        }
        itemPedidoRepo.save(item);
        String msg = "Produto inserido com sucesso no pedido";
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/api/item-pedido")
    public ResponseEntity<String> atualizar(@RequestBody ItemPedido item){
        itemPedidoRepo.save(item);
        String msg = "Produto atualizado com sucesso no pedido";
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/api/item-pedido/{id}")
    public ResponseEntity<ItemPedido> consultar(@PathVariable long id){
        Optional<ItemPedido> produto = itemPedidoRepo.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.ok(new ItemPedido());
        }
    }
    @GetMapping("/api/item-pedido/lista")
    public ResponseEntity<List<ItemPedido>> listar(){
        List<ItemPedido> lista = itemPedidoRepo.findAll();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/api/item-pedido/listar/{id}")
    public ResponseEntity<List<ItemPedido>> listarPedido(@PathVariable long id){
        List<ItemPedido> lista = itemPedidoRepo.listarProdutos(id);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);

        }
    }
    @DeleteMapping("/api/item-pedido/{id}")
    public ResponseEntity<String> excluir(@PathVariable long id){
        itemPedidoRepo.deleteById(id);
        String msg = "Produto excluído com sucesso";
        return ResponseEntity.ok(msg);
    }
}
