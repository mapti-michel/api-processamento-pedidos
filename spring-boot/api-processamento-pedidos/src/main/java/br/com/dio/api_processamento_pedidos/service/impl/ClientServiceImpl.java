package br.com.dio.api_processamento_pedidos.service.impl;

import br.com.dio.api_processamento_pedidos.model.Cliente;
import br.com.dio.api_processamento_pedidos.repository.ClienteRepository;
import br.com.dio.api_processamento_pedidos.repository.PedidoRepository;
import br.com.dio.api_processamento_pedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarCliente(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public void salvarCliente(Cliente cliente){
        Cliente nomeCliente = clienteRepository.findByNome(cliente.getNome()).orElseGet(() -> {
            // Caso não exista, cadastre um novo cliente
            Cliente novoCliente = new Cliente();
            novoCliente.setNome(cliente.getNome());
            clienteRepository.save(novoCliente);
            return novoCliente;
        });
        cliente.setNome(nomeCliente.getNome());
        clienteRepository.save(cliente);

    }

}
