package espm.aulas.aula07;

import espm.banco.Conta;
import espm.banco.ContaCorrente;

public class Lixo {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Memória total da JVM -> "+rt.totalMemory());
        Conta c;
        for(int i = 0; i < 10000000; i++) {
            c = new ContaCorrente();
            c = null;
        }
        System.out.println("Livre antes da coleta -> "+rt.freeMemory());
        rt.gc();
        System.out.println("Memória total da JVM -> "+rt.totalMemory());
        System.out.println("Livre depois da coleta -> "+rt.freeMemory());
    }
}
