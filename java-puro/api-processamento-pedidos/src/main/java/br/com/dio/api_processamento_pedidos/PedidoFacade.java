package br.com.dio.api_processamento_pedidos;

public class PedidoFacade {

    public void processarPedido(double valor, PagamentoStrategy pagamento){
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        
        System.out.println("Sistema: " + config.getNomeSistema());

        pagamento.pagar(valor);
    }
    
}
