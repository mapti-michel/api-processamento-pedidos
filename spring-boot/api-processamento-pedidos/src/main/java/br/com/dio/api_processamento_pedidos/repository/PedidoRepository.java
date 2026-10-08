package br.com.dio.api_processamento_pedidos.repository;

import br.com.dio.api_processamento_pedidos.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
