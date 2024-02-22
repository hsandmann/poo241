package espm.aulas.aula01;

import espm.banco.Conta;

public class Experimento03 {

    public static void main(String[] args) {
        
        Conta c1 = new Conta();
        System.out.println("c1: " + c1.getId() + " -> " + c1.getSaldo());

        c1.depositar(100);
        System.out.println("c1: " + c1.getId() + " -> " + c1.getSaldo());

        c1.sacar(120);
        System.out.println("c1: " + c1.getId() + " -> " + c1.getSaldo());

        c1.sacar(30);
        System.out.println("c1: " + c1.getId() + " -> " + c1.getSaldo());

        c1.sacar(40);
        System.out.println("c1: " + c1.getId() + " -> " + c1.getSaldo());

    }
    
}
