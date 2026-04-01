/*
 * Copyright (c) $today.year.Feito por Betina Volpi Nazário
 */

package br.com.valueprojects.service;

import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.dominio.Tarefa;

public class CriadorEstimativaJava {
    private final CalculadoraProdutividade calculadoraProdutividade;
    private final NotificadorEstimativa notificadorEstimativa;
    private final EstimativaRepository estimativaRepository;

    // Construtor recebe CalculadoraProdutividade como parâmetro
    public CriadorEstimativaJava(CalculadoraProdutividade calculadoraProdutividade,
                                 NotificadorEstimativa notificadorEstimativa,
                                 EstimativaRepository estimativaRepository) {
        this.calculadoraProdutividade = calculadoraProdutividade;
        this.notificadorEstimativa = notificadorEstimativa;
        this.estimativaRepository = estimativaRepository;
    }


    public EstimativaJava cria(Tarefa tarefa) {
        double metrica = tarefa.metricaTarefa();
        // Deleção
        double produtividade = calculadoraProdutividade.calcular(metrica);
        String perfil = calculadoraProdutividade.getPerfil();

        EstimativaJava estimativaJava = new EstimativaJava(metrica, produtividade, perfil);

        notificadorEstimativa.notificar(estimativaJava);
        estimativaRepository.salvar(estimativaJava);

        return estimativaJava;
    }
}

