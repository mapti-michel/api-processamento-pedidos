package br.com.dio.api_processamento_pedidos;

/*
 **************************************************
 * FACADE
 * ************************************************
 */

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoFacade {

    private final List<PagamentoStrategy> pagamentos;

    public PedidoFacade(List<PagamentoStrategy> pagamentos){
        this.pagamentos = pagamentos;
    }

    public void processarPedido(double valor, String formaPagamento){
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        
        System.out.println("Sistema: " + config.getNomeSistema());

        for(PagamentoStrategy pagamento: pagamentos){
            if(pagamento.getClass().getSimpleName().equalsIgnoreCase("Pagamento" + formaPagamento)){
                pagamento.pagar(valor);
                return;
            }
        }

        throw new IllegalArgumentException("Forma de pagamento não suportada: " + formaPagamento);
    }
    
}
