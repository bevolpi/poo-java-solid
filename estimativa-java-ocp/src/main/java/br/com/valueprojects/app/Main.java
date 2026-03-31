package br.com.valueprojects.app;

import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.dominio.Tarefa;
import br.com.valueprojects.infra.notificacao.EmissorDeSms;
import br.com.valueprojects.infra.persistencia.EstimativaJavaDao;
import br.com.valueprojects.service.CalculadoraProdutividade;
import br.com.valueprojects.service.CalculadoraProdutividadeJunior;
import br.com.valueprojects.service.CriadorEstimativaJava;
import br.com.valueprojects.service.EstimativaRepository;
import br.com.valueprojects.service.NotificadorEstimativa;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Tarefa tarefa = new Tarefa(1, "Criar endpoint de autenticação", 120);

        System.out.println("------------------TAREFA-----------------\n");
        System.out.println(tarefa);
        System.out.println();

        System.out.println("-----ARMAZENAMENTO E DISPONIBILIDADE-----");
        CalculadoraProdutividade calculadora = new CalculadoraProdutividadeJunior();
        NotificadorEstimativa notificador = new EmissorDeSms();
        EstimativaRepository repository = new EstimativaJavaDao();
        System.out.println();

        CriadorEstimativaJava criador = new CriadorEstimativaJava(calculadora, notificador, repository);

        EstimativaJava estimativa = criador.cria(tarefa);
        System.out.println();

        System.out.println("------------------------------------------");
        System.out.println("Resultado final da estimativa: " + estimativa);
    }
}
