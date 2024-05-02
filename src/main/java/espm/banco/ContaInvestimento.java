package espm.banco;

public class ContaInvestimento extends Conta implements Rendimento {

    public void sacar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > saldo) throw new BancoException("Saldo insuficiente");
        saldo -= valor;
    }

    public double taxa() {
        return 0.02;
    }
    
}
