package br.com.valueprojects.infra.persistencia;

import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.service.EstimativaRepository;

public class EstimativaJavaDao implements EstimativaRepository {
    @Override
    public void salvar(EstimativaJava estimativaJava) {
        System.out.println("Estimativa salva no banco: " + estimativaJava);
    }
}
