package br.com.dio.api_processamento_pedidos;

public class ConfiguracaoSistema {

    private static ConfiguracaoSistema instancia;

    private ConfiguracaoSistema(){

    }

    public static ConfiguracaoSistema getInstancia(){
        if(instancia == null){
            instancia = new ConfiguracaoSistema();
        }

        return instancia;
    }

    public String getNomeSistema(){
        return "API de Processamento de Pedidos";
    }

  

}
