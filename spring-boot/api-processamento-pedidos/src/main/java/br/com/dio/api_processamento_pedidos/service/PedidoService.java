package br.com.dio.api_processamento_pedidos.service;

import br.com.dio.api_processamento_pedidos.model.Pedido;

public interface PedidoService {

    Iterable<Pedido> buscarTodos();

    Pedido buscarPorId(Long id);

    void inserir(Pedido pedido);

    void atualizar(Long id, Pedido pedido);

    void deletar(Long id);


}
