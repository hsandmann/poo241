package espm.aulas.aula01;

import espm.banco.Conta;

public class Experimento06 {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        final Conta c1 = new Conta();
        System.out.println(c1.getActiva());

        Conta.LIMIT = 100;


    }

}
