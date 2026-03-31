package br.com.valueprojects.infra;

// essa classe faz parte dos recursos não funcionais, por ex, quando a estimativa é criada
// é emitido um sms para a pessoa com os valores armazenados na estimativa
import br.com.valueprojects.dominio.EstimativaJava;

public class EmissorDeSms {

    public void emitirSms(EstimativaJava estJava) {
        System.out.println("SMS enviado com a estimativa: " + estJava);
    }
}
