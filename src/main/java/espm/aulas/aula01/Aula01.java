package espm.aulas.aula01;

import java.util.Scanner;

public class Aula01 {

    public static void main(String[] args) {
        System.out.println("ESPM, exercicio do sr. mini!");
        Scanner scanner = new Scanner(System.in);
        String linha = "";
        while (true) {
            System.out.print("> ");
            linha = scanner.nextLine().trim();
            if (linha.equalsIgnoreCase("exit")) break;
            else if (linha.equalsIgnoreCase("ex3")) ex3();
            else if (linha.equalsIgnoreCase("ex4")) ex4();
        }
        System.out.println("bye bye! see you later!");
        scanner.close();
    }

    public static void ex3() {
        System.out.println("Exercicio 3");
        long n = 600851475143l;
        int primo = 2;
        while (n > 1) {
            if (n % primo == 0) {
                System.out.println(primo);
                n = n / primo;
            } else if (primo == 2) {
                primo++;
            } else {
                primo += 2;
            }
        }
        System.out.println("maior primo: " + primo);
    }

    public static boolean eh_palindromo(long x) {
        long m = 0;
        long n = x;
        while (n > 0) {
            m = m * 10 + n % 10;
            n = n / 10;
        }
        return m == x;
    }

    public static void ex4() {
        long maior = 0;
        for (int i = 100; i < 1000; i++)
            for (int j = 1000; j > 100; j--) {
                int n = i * j;
                if (eh_palindromo(n) && n > maior) maior = n;
            }
        System.out.println("maior palindromo: " + maior);
    }

}
