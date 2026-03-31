package br.com.valueprojects.infra.notificacao;

import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.service.NotificadorEstimativa;

public final class EmissorDeEmail implements NotificadorEstimativa {
    @Override
    public void notificar(EstimativaJava estimativaJava) {
        System.out.println("E-mail enviado com a estimativa: " + estimativaJava);
    }
}
