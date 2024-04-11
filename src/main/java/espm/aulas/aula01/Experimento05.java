package espm.aulas.aula01;

import java.util.Date;

import espm.banco.Cliente;
import espm.banco.PessoaFisica;

public class Experimento05 {

    public static void main(String[] args) {
        Cliente c1 = new PessoaFisica("12345678901", "Seumini");
        ((PessoaFisica) c1).setBirthdate(new Date()); // cast de tipo

        PessoaFisica c2 = new PessoaFisica("2123", "Rafa Windows");
        c2.setBirthdate(new Date());

        Cliente c3 = c1;

        System.out.println(c1);
        System.out.println(c3);

        c3.setName("Teuminizinho");
        System.err.println(c1);

    }
    
}
