package br.com.dio.api_processamento_pedidos;

/*
 **************************************************
 * STRATEGY
 * ************************************************
 */

import org.springframework.stereotype.Component;

@Component
public class PagamentoCartao implements PagamentoStrategy{

    @Override
    public void pagar(double valor){
        System.out.println("Pagamento de R$ " + valor + " realizado via Cartão.");
    }

    
}
