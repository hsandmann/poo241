package espm.aulas.aula01;

import espm.banco.Bank;

public class Experimento02 {

    public static void main(String[] args) {

        Bank espmBank = new Bank();
        espmBank.setName("ESPM Bank");
        System.out.println(espmBank.getName());

    }

}
