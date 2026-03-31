package br.com.valueprojects.infra.notificacao;

import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.service.NotificadorEstimativa;

public class EmissorDeSms implements NotificadorEstimativa {
    @Override
    public void notificar(EstimativaJava estimativaJava) {
        System.out.println("SMS enviado com a estimativa: " + estimativaJava);
    }
}
