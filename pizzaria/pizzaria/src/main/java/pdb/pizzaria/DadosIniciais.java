package pdb.pizzaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pdb.pizzaria.model.Cliente;
import pdb.pizzaria.repository.ClienteRepository;

@Component
public class DadosIniciais {
    @Autowired
    private ClienteRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Cliente(1L, "Josias", "11789456123", "Rua Um, 1", "zxc123"));
        repository.save(new Cliente(2L, "Jéssica", "888888888", "Rua Dois, 2", "abc456"));
        repository.save(new Cliente(3L, "João", "11987654321", "Rua Três, 15", "def789"));
        repository.save(new Cliente(4L, "Janaina", "1155556666", "Rua Quatro, 30", "ghi012"));
        repository.save(new Cliente(5L, "Jacó", "1155556666", "Rua Cinco, 50", "asd234"));
    }
}