package espm.banco;

import java.util.UUID;

public abstract class Conta {

    public static final double INITIAL_VALUE = 0;

    static {
        System.out.println("Conta inicializada");
    }

    private String id = UUID.randomUUID().toString();
    protected double saldo = INITIAL_VALUE;
    private boolean ativa = true;

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (!ativa) throw new BancoException("Conta inativa");
        if (valor > 0) saldo += valor;
    }
    
    public abstract void sacar(double valor);

    public void sacar(String valor) {
        sacar(Double.parseDouble(valor));
    }

    public boolean getActiva() {
        return ativa;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", saldo: " + saldo + ", ativa: " + ativa + "]";
    }

}
