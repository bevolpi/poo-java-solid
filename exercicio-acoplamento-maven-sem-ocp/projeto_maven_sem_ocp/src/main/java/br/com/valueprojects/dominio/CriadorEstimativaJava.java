package br.com.valueprojects.dominio;
// classe de serviço, é onde os requisitos funcionais acontecen
// EXEMPLO DE MAL ACOPLAMENTO, ACOPLAMENTO EFERENTE
// essa classe faz coisa de mais

// valueprojects é a empresa, ent ela está em um dominio
import br.com.valueprojects.dao.EstimativaJavaDao;
import br.com.valueprojects.infra.EmissorDeSms;

public class CriadorEstimativaJava {
    //recebe as classes concretas para envio pós armazenamento da estimativa
    private final EmissorDeSms sms;
    private final EstimativaJavaDao dao;

    // injetado por dependencia o sms e o dao (nasce com eles)
    public CriadorEstimativaJava(EmissorDeSms sms, EstimativaJavaDao dao) {
        this.sms = sms;
        this.dao = dao;
    }

    // pega as infos da Tarefa e cria a estimativa com a metrica
    public EstimativaJava cria(Tarefa tarefa) {
        double metrica = tarefa.getMetricaTarefa();

        EstimativaJava estJava = new EstimativaJava(
                metrica,
                produtividadeDesenvolvedorJunior(metrica)
        );

        // emite e insere no banco
        sms.emitirSms(estJava);
        dao.insere(estJava);

        // retorna o toString do objeto dessa EstimativaJava
        return estJava;
    }

    //calcula a produtividadeJunior baseada na metrica
    private double produtividadeDesenvolvedorJunior(double metrica) {
        return metrica * 0.04;
    }
}

// o grande problema do código é essa classe, ela tem diversas funcionalidades. ela realiza o
// cálculo matemático da métrica, orquestra o envio das notificações e coordena a persistência
// no banco de dados -> 3 MOTIVOS PARA SER MODIFICADA DEPENDENDO DAS RNs
// Um motivo, por exemplo,
// uma delas é calcular a produtividade do Junior, e para isso, adiciona no final do código
// com o calculo utilizando número constante. Isso fere o O do SOLID, pq caso a empresa queira
// contratar um Senior ou Pleno, será necessário abrir essa classe e modificá-la por completo
// complexificando e adicionando diversas novas condições, o que faz com que a classe fique
// confusa e calculos que já funcionam perfeitamente podem ser corrompidos.

// além disso, seria necessário mudar a classe Tarefa também, para diferenciar qual o "nível"
// do desenvolvedor --> isso dificulta muito a manutenção do código, principalmente em projetos
// mais complexos

// Ademais a classe está amarrada/engessada, ou seja, fortemente acoplada com o SMS e o DAO.
// Portanto, caso haja uma mudança na infra com a modificação de uma RN, a classe de criação
// também quebra. Se não usarem o SMS mais ou quiserem adicionar um emissor pelo email, é
// necessário apagar variáveis adicionar métodos, e até alterar o construtor, causando um
// efeito cascata

// qualquer mínima alteração vai exigir que o programador abra o arquivo Criador, correndo risco
// de modificar algo e quebrartodo o restante do código
