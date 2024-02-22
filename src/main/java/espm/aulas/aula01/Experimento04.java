package espm.aulas.aula01;

import espm.banco.Bank;

public class Experimento04 {

    public static void main(String[] args) {

        Bank banco = new Bank("ESPM");

        System.out.println(banco.getContas());
        System.out.println(banco.getName());
        
    }

}
