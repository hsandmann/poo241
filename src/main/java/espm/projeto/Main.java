package espm.projeto;

import java.util.Set;
import java.util.Scanner;

import espm.banco.BancoException;
import espm.banco.Bank;
import espm.banco.Cliente;
import espm.banco.PessoaFisica;
import espm.banco.PessoaJuridica;

public class Main {

    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank banco = new Bank();
        while (true) {

            try {

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

                } else if (comando.trim().length() == 0) {
                } else {
                    throw new IllegalArgumentException("Comando inválido");
                }
            } catch (BancoException e) {
                e.printStackTrace();
                System.err.println("Excecao de negocio: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println("Erro em tempo de execucao: " + e.getMessage());            
            } catch (Exception e) {
                System.err.println("Erro inesperado: " + e.getMessage());
            } catch (Throwable e) {
                System.err.println("Erro fatal: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Bye bye!");
    }

    private static Cliente createCustomer() {
        String tipo = readString("Tipo [F|J]: ", Set.of("F", "J"));
        String nome = readString("Nome: ", Set.of());
        String cpfCnpj = readString("CPF/CNPJ: ", Set.of());
        return "F".equals(tipo)
            ? new PessoaFisica(cpfCnpj, nome)
            : new PessoaJuridica(cpfCnpj, nome);

    }

    private static String readString(String prompt, Set<String> validos) {
        while (true) {
            try {
                System.out.print(prompt);
                String content = scanner.nextLine().trim();
                if (content.length() == 0) {
                    throw new BancoException("Valor não pode ser vazio");
                } else if (validos.size() > 0 && !validos.contains(content)) {
                    throw new BancoException("Valor inválido");
                }
                return content;
            } catch (BancoException e) {
                System.err.println("Erro ao ler valor: " + e.getMessage());
            }
        }
    }
    
}
