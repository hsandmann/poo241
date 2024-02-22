package espm.banco;

import java.util.Date;
import java.util.UUID;

public class Cliente {

    private String id;
    private String cpf;
    private String name;
    private Date birthdate;

    public Cliente() {
        this.id = UUID.randomUUID().toString();
    }

    public Cliente(String cpf) {
        this();
        this.cpf = cpf;
    }

    public Cliente(String cpf, String name) {
        this(cpf);
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

    public String getCpf() {
        return cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id
            + ", cpf=" + cpf
            + ", name=" + name
            + ", birthdate=" + birthdate
        + "]";
    }
    
}
