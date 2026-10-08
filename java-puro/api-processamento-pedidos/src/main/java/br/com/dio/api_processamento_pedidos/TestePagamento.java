package br.com.dio.api_processamento_pedidos;

public class TestePagamento {
    
    public static void main(String[] args){
        
        PagamentoStrategy pagamentoPix = new PagamentoPix();
        pagamentoPix.pagar(100.00);

        PagamentoStrategy pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.pagar(200.00);

        System.out.println("\n*********** Pedidos Facade ***************");

        PedidoFacade pedido = new PedidoFacade();

        PagamentoStrategy pix = new PagamentoPix();
        pedido.processarPedido(100.00, pix);

        PagamentoStrategy cartao = new PagamentoCartao();
        pedido.processarPedido(250.00, cartao);

    }
}
