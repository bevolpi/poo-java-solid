package br.com.valueprojects.app;
//esse código nao segue regras do SOLID pq infringe o O, em que deve-se conseguir
// adicionar novos comportamentos sem precisar alterar o código fonte

//estimativa de tarefas, tentar prever o esforço, tempo e custo que será necessário
import br.com.valueprojects.dao.EstimativaJavaDao;
import br.com.valueprojects.dominio.CriadorEstimativaJava;
import br.com.valueprojects.dominio.EstimativaJava;
import br.com.valueprojects.dominio.Tarefa;
import br.com.valueprojects.infra.EmissorDeSms;

// CÓDIGO MUITO ACOPLADO
public class Main {

    public static void main(String[] args) {
        //criei a tarefa e atribuí os valores
        Tarefa tarefa = new Tarefa();
        tarefa.setIdTarefa(1);
        tarefa.setDescricaoTarefa("Criar API de cadastro de clientes");
        tarefa.setMetricaTarefa(120.0);

        // aqui, chamei o emissor e a estimativaDao para instanciar a mensagem de estimativa
        // "preparei o terreno que será processado no criador"
        EmissorDeSms sms = new EmissorDeSms();
        EstimativaJavaDao dao = new EstimativaJavaDao();
        // o criador pega as funções do dao e do sms para enviar a estimativa
        CriadorEstimativaJava criador = new CriadorEstimativaJava(sms, dao);

        //com tudo já organizado, executa a ação para criar a estimativa segundo as infos da tarefa
        EstimativaJava estimativa = criador.cria(tarefa);

        System.out.println("Resultado final da estimativa: " + estimativa);
    }
}
