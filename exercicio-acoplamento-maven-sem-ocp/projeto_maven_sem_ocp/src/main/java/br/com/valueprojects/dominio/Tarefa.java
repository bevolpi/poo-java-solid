package br.com.valueprojects.dominio;

// essa aqui tbm tem sugestoes, nesse caso nao pode record pq tem o set
//  essa classe define qual a tarefa a ser feita

public class Tarefa {

    private int idTarefa;
    private String descricaoTarefa;
    private double metricaTarefa;

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public double getMetricaTarefa() {
        return metricaTarefa;
    }

    public void setMetricaTarefa(double metricaTarefa) {
        this.metricaTarefa = metricaTarefa;
    }
}
