package pdb.pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import pdb.pizzaria.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>, JpaSpecificationExecutor<ItemPedido> {
    @Query(value = "SELECT * FROM pedido_produto WHERE pedido_id =?1", nativeQuery = true)
    List<ItemPedido> listarProdutos(long pedido_id);
}
