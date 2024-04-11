package espm.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {

    private String id;
    private String name;
    private List<Conta> contas;

    protected Cliente(String name) {
        this.id = UUID.randomUUID().toString();
        this.contas = new ArrayList<>();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id
            + ", name=" + name
        + "]";
    }
    
}
