package br.com.dio.api_processamento_pedidos.service;

import br.com.dio.api_processamento_pedidos.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);


}
