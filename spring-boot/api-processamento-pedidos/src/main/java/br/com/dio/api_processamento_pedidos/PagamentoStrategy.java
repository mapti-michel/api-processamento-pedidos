package br.com.dio.api_processamento_pedidos;

/*
**************************************************
* STRATEGY
* ************************************************
*/

public interface PagamentoStrategy {
    
    void pagar(double valor);


}
