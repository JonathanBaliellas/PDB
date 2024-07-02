package pdb.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pdb.pizzaria.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>, JpaSpecificationExecutor<Entrega> {
    
}
