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

    /*
     * A aplicação de rendimento é feita de forma diferente para contas de
     * investimento. Se o rendimento for menor que 10, é aplicado um valor fixo
     * de 10 reais. Caso contrário, o rendimento é aplicado normalmente.
     */
    @Override
    public void aplicar() {
        double rendimento = saldo * taxa();
        if (rendimento < 10) saldo += 10;
        else saldo += rendimento;
    }

    @Override
    public String toString() {
        return "Investimento: " + super.toString();
    }
    
}
