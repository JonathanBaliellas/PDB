package pdb.pizzaria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate data;
    private LocalTime hora;
    private int quantidadeItens;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("pedidos")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("pedido")
    private List<ItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "entrega_id")
    @JsonIgnoreProperties("pedidos")
    private Entrega entrega;
}
