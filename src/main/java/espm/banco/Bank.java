package espm.banco;

import java.util.List;

public class Bank {

    private String name;
    private List<Conta> contas;

    // construtor
    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Conta> getContas() {
        return contas;
    }

}
