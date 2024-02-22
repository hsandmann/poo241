package espm.aulas.aula01;

import java.util.Date;

import espm.banco.Cliente;

public class Experimento05 {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("12345678901", "Seumini");
        c1.setBirthdate(new Date());

        Cliente c2 = new Cliente("2123", "Rafa Windows");
        c2.setBirthdate(new Date());

        Cliente c3 = c1;

        System.out.println(c1);
        System.out.println(c3);

        c3.setName("Teuminizinho");
        System.err.println(c1);

    }
    
}
