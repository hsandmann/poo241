package espm.aulas.aula07;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {

        int[] numeros = new int[] {10, 12, 13, 14, 15};

        // o iterable eh feito sobre o indice
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + ", ");
        }
        System.out.println();

        // o iterable eh feito sobre o objeto
        for (int numero : numeros) {
            System.out.print(numero + ", ");
        }
        System.out.println();

        // stream
        Arrays.stream(numeros).forEach(n -> System.out.print(n + ", "));
        System.out.println();

    }
    
}
