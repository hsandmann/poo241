package espm.banco;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Conta> contas;
    private List<Cliente> clientes = new ArrayList<>();

    // construtor
    public Bank(String name) {
        System.out.println("chamando Bank(String)");
        this.name = name;
        this.contas = new ArrayList<>();
    }

    public Bank() {
        this("Banco da ESPM");
        System.out.println("chamando Bank()");
    }

    public String getName() {
        return name;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}
