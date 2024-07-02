package pdb.pizzaria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pdb.pizzaria.model.Cliente;
import pdb.pizzaria.model.ItemPedido;
import pdb.pizzaria.model.Pedido;
import pdb.pizzaria.repository.ClienteRepository;
import pdb.pizzaria.repository.PedidoRepository;

@Component
public class DadosIniciais {
    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private PedidoRepository pedidoRepo;

    @PostConstruct
    public void init() {
        List<Pedido> pedidosVazios = new ArrayList<>();
        
        Cliente cliente1 = new Cliente(1L, "Josias", "11789456123", "Rua Um, 1", "zxc123", pedidosVazios);
        Cliente cliente2 = new Cliente(2L, "Jéssica", "888888888", "Rua Dois, 2", "abc456", pedidosVazios);
        Cliente cliente3 = new Cliente(3L, "João", "11987654321", "Rua Três, 15", "def789", pedidosVazios);
        Cliente cliente4 = new Cliente(4L, "Janaina", "1155556666", "Rua Quatro, 30", "ghi012", pedidosVazios);
        Cliente cliente5 = new Cliente(5L, "Jacó", "1155556666", "Rua Cinco, 50", "asd234", pedidosVazios);

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3, cliente4, cliente5);

        clienteRepo.saveAll(clientes);

        List<ItemPedido> itensVazios = new ArrayList<>();
        pedidoRepo.save(new Pedido(1L, LocalDate.now(), LocalTime.now(), 50, BigDecimal.valueOf(250), cliente1, itensVazios));

        
    }
}