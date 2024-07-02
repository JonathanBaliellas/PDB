package pdb.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pdb.pizzaria.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>, JpaSpecificationExecutor<ItemPedido> {
    
}
