package br.com.valueprojects.dominio;

import java.util.Objects;

public final class Tarefa {
    private final int idTarefa;
    private final String descricaoTarefa;
    private final double metricaTarefa;

    public Tarefa(int idTarefa, String descricaoTarefa, double metricaTarefa) {
        this.idTarefa = idTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.metricaTarefa = metricaTarefa;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                ", descricaoTarefa='" + descricaoTarefa + '\'' +
                ", metricaTarefa=" + metricaTarefa +
                '}';
    }

    public int idTarefa() {
        return idTarefa;
    }

    public String descricaoTarefa() {
        return descricaoTarefa;
    }

    public double metricaTarefa() {
        return metricaTarefa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Tarefa) obj;
        return this.idTarefa == that.idTarefa &&
                Objects.equals(this.descricaoTarefa, that.descricaoTarefa) &&
                Double.doubleToLongBits(this.metricaTarefa) == Double.doubleToLongBits(that.metricaTarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarefa, descricaoTarefa, metricaTarefa);
    }

}
