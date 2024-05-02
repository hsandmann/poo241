package espm.banco;

public class ContaPoupanca extends Conta implements Rendimento {

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    @Override
    public double taxa() {
        return 0.01;
    }

    @Override
    public void aplicar() {
        this.saldo += this.saldo * this.taxa();
    }

    @Override
    public String toString() {
        return "Poupanca: " + super.toString();
    }
    
}
