package br.com.dio.api_processamento_pedidos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;
    private String formaPagamento;

    @ManyToOne
    private Cliente cliente;

}
