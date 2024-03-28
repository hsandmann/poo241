package espm.aulas.aula07;

public class MultiArray {

    public static void main(String[] args) {

        int[][] matriz = new int[][] {
            {10, 12, 13, 14, 15},
            {20, 22, 23, 24, 25},
            {30, 32, 33, 34, 35}
        };

        for (int[] linha : matriz) {
            for (int elemento : linha)
                System.out.print(elemento + ", ");
            System.out.println();
        }
        
    }

}
