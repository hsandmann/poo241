package espm.banco;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String cnpj, String name) {
        super(name);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
