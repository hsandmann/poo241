package espm.banco;

import java.util.UUID;

public class Conta {

    public static final double INITIAL_VALUE = 0;
    public static double LIMIT = 50;

    static {
        System.out.println("Conta inicializada");
    }

    private String id = UUID.randomUUID().toString();
    private double limite = LIMIT;
    private double saldo = INITIAL_VALUE;
    private boolean ativa;

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }
    
    public void sacar(double valor) {
        if (valor < 0)
            throw new RuntimeException("Saque negativo nao permitido");
        if (valor > saldo + limite)
            throw new RuntimeException("Saldo insuficiente");
        saldo -= valor;
    }

    public void sacar(String valor) {
        sacar(Double.parseDouble(valor));
    }

    public boolean getActiva() {
        return ativa;
    }

}
