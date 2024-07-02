package pdb.pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import pdb.pizzaria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido>{
    @Query(value = "SELECT * FROM pedido WHERE cliente_id = ?1", nativeQuery = true)
    List<Pedido> findByCliente(long cliente_id);
}
