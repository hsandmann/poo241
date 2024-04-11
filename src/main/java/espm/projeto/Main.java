package espm.projeto;

import java.util.Scanner;

import espm.banco.Bank;
import espm.banco.Cliente;
import espm.banco.PessoaFisica;
import espm.banco.PessoaJuridica;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank banco = new Bank();
        while (true) {

            System.out.print(banco.getName() + "> ");
            String comando = scanner.nextLine().trim();

            if (comando.toLowerCase().equals("exit")) {
                break;

            } else if (comando.toLowerCase().equals("help")) {
                System.out.println("Comandos disponíveis:");
                System.out.println("  help - exibe esta mensagem");
                System.out.println("  exit - sai do programa");
                System.out.println("  customer - cria novo cliente");

            } else if (comando.toLowerCase().equals("customer")) {
                Cliente cliente = createCustomer();
                banco.getClientes().add(cliente);

            } else if (comando.toLowerCase().equals("list")) {
                for (Cliente cliente : banco.getClientes()) {
                    String saida = (cliente instanceof PessoaFisica pf)
                        ? "cpf: " + pf.getCpf()
                        : "cnpj: " + ((PessoaJuridica) cliente).getCnpj();
                    System.out.println(saida + "| " + cliente.getName());
                }

            } else {
                System.out.println("Comando não reconhecido");
            }
        }
        System.out.println("Bye bye!");
        scanner.close();
    }

    private static Cliente createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tipo [P|J]: ");
        String tipo = scanner.nextLine().trim().toLowerCase();
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("CPF/CNPJ: ");
        String cpfCnpj = scanner.nextLine().trim();
        return "f".equals(tipo)
            ? new PessoaFisica(cpfCnpj, nome)
            : new PessoaJuridica(cpfCnpj, nome);
    }
    
}
