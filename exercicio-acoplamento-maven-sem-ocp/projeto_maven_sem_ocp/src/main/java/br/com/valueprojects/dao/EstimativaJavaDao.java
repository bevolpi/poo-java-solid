package br.com.valueprojects.dao;

import br.com.valueprojects.dominio.EstimativaJava;
// Dao serve para conversar com o banco de dados!!
// o metodo "insere" recebe o valor da estimativa e simula o salvamento dele no SQL
//na vida real, teria um query "INSERT INTO..."

public class EstimativaJavaDao {

    public void insere(EstimativaJava estJava) {
        System.out.println("Estimativa salva no banco: " + estJava);
    }
}
