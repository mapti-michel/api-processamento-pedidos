package br.com.dio.api_processamento_pedidos.service.impl;

import br.com.dio.api_processamento_pedidos.PedidoFacade;
import br.com.dio.api_processamento_pedidos.model.Cliente;
import br.com.dio.api_processamento_pedidos.model.Pedido;
import br.com.dio.api_processamento_pedidos.repository.ClienteRepository;
import br.com.dio.api_processamento_pedidos.repository.PedidoRepository;
import br.com.dio.api_processamento_pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoFacade pedidoFacade;


    @Override
    public Iterable<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }

    @Override
    public void inserir(Pedido pedido) {
        salvarPedido(pedido);
    }

    @Override
    public void atualizar(Long id, Pedido pedido) {
        Optional<Pedido> pedidoId = pedidoRepository.findById(id);
        if(pedidoId.isPresent()){
            salvarPedido(pedido);
        }
    }

    @Override
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void salvarPedido(Pedido pedido){
        Cliente cliente = pedido.getCliente();
        Cliente nomeCliente = clienteRepository.findByNome(cliente.getNome()).orElseGet(() -> {
            // Caso não exista, cadastre um novo cliente
            Cliente novoCliente = new Cliente();
            novoCliente.setNome(cliente.getNome());
            clienteRepository.save(novoCliente);
            return novoCliente;
        });
        pedido.setCliente(nomeCliente);
        pedidoFacade.processarPedido(pedido.getValor(), pedido.getFormaPagamento());
        pedidoRepository.save(pedido);
    }
}
