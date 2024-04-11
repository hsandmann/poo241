package espm.aulas.aula07;

import espm.banco.Conta;
import espm.banco.ContaCorrente;

public class Experimento01 {

    public static void main(String[] args) {

        Conta c1 = new ContaCorrente();
        c1.depositar(50);
        c1.sacar("10.34");
        c1.sacar(5);
        System.out.println(c1.getSaldo());

        Conta c2 = new ContaCorrente();
        Conta c3 = new ContaCorrente();
        System.out.println(c2.getSaldo());
        System.out.println(c3.getSaldo());

        // remove objetos sem referencia da memoria
        System.gc();
        // apesar de existir o comando, a especificacao
        // da JVM nao aconselha a execucao
        
    }

}
