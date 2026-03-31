package br.com.valueprojects.service;

public class CalculadoraProdutividadeJunior implements CalculadoraProdutividade {
    @Override
    public double calcular(double metrica) {
        return metrica * 0.04;
    }

    @Override
    public String getPerfil() {
        return "Desenvolvedor Júnior";
    }
}
