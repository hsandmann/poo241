package espm.aulas.aula07;

import java.util.Arrays;

public class MetodoTamanhoN {

    public static void main(String[] args) {

        System.out.println(soma(1, 2, 3, 4, 5, 6));
        System.out.println(soma(1, 2, 3, 4));
        
    }

    public static int soma(int... valores) {
        return Arrays.stream(valores).sum();
    }

}
