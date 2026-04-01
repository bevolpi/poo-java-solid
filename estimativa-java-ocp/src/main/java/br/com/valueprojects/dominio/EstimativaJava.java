/*
 * Copyright (c) $today.year.Feito por Betina Volpi Nazário
 */

package br.com.valueprojects.dominio;

public record EstimativaJava(double metrica, double produtividadeDesenvolvedor, String perfil) {

    @Override
    public String toString() {
        return "EstimativaJava{" +
                "metrica=" + metrica +
                ", produtividadeDesenvolvedor=" + produtividadeDesenvolvedor +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
