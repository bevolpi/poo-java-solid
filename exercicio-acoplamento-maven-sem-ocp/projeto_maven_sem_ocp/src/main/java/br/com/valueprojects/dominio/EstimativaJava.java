package br.com.valueprojects.dominio;
//RECORD
// aqui, apertei com botao direito e a IDE me deu ideia de que minha classe
// ta mto complexa, um perfil muito complexo -> fiz um record

// essa classe só guarda as informações da estimativa criada. Minha estimativa é x, portanto
// armazeno essa info nessa classe, em que não poderá ser modificada

import java.util.Objects;

public record EstimativaJava(double metrica, double produtividadeDesenvolvedorJunior) {

    @Override
    public String toString() {
        return "EstimativaJava{" +
                "metrica=" + metrica +
                ", produtividadeDesenvolvedorJunior=" + produtividadeDesenvolvedorJunior +
                '}';
    }

}
