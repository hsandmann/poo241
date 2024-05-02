package espm.projeto;

import java.util.Set;
import java.util.Scanner;

import espm.banco.BancoException;
import espm.banco.Bank;
import espm.banco.Cliente;
import espm.banco.Conta;
import espm.banco.ContaCorrente;
import espm.banco.ContaInvestimento;
import espm.banco.ContaPoupanca;
import espm.banco.PessoaFisica;
import espm.banco.PessoaJuridica;
import espm.banco.Rendimento;

public class Main {

    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente currentCustomer = null;
        Conta currentAccount = null;
        Bank banco = new Bank();
        while (true) {

            try {

                String prompt = banco.getName() + "::"
                    + ((currentCustomer == null)
                        ? ""
                        : currentCustomer.getName())
                    + ((currentAccount == null)
                        ? ""
                        : ":" + currentAccount.getId());
                System.out.print(prompt + "> ");
                String[] comando = scanner.nextLine().trim().split(" ");

                if (comando.length == 0 || comando[0].isEmpty()) {
                } else if (comando[0].toLowerCase().equals("exit")) {
                    break;
                } else if (comando[0].toLowerCase().equals("help")) {
                    System.out.println("Comandos disponíveis:");
                    System.out.println("  help - exibe esta mensagem");
                    System.out.println("  exit - sai do programa");
                    System.out.println("  customer - cria novo cliente");

                } else if (comando[0].toLowerCase().equals("customer")) {
                    if (comando.length == 1) {
                        Cliente cliente = createCustomer();
                        banco.getClientes().add(cliente);
                        currentCustomer = cliente;
                    } else if (comando.length == 2) {
                        if (comando[1].toLowerCase().equals("list")) {
                            for (Cliente cliente : banco.getClientes()) {
                                String saida = (cliente instanceof PessoaFisica pf)
                                    ? "cpf: " + pf.getCpf()
                                    : "cnpj: " + ((PessoaJuridica) cliente).getCnpj();
                                System.out.println(saida + "| " + cliente.getName());
                            }
                        } else if (comando[1].toLowerCase().equals("exit")) {
                            currentCustomer = null;
                            currentAccount = null;
                        } else {
                            String cpfCnpj = comando[1];
                            currentCustomer = banco.getClientes().stream()
                                .filter(c -> 
                                    (c instanceof PessoaFisica pf && pf.getCpf().equals(cpfCnpj)) ||
                                    (c instanceof PessoaJuridica pj && pj.getCnpj().equals(cpfCnpj))
                                )
                                .findFirst()
                                .orElseThrow(() -> new BancoException("Cliente não encontrado"));
                        }
                    } else {
                        throw new BancoException("Número de argumentos inválido");
                    }
 
                } else if (comando[0].equalsIgnoreCase("account")) {
                    if (currentCustomer == null)
                        banco.getContas().forEach(c -> System.out.println(c));
                    else {
                        if (comando.length == 1) {
                            Conta conta = createAccount(currentCustomer);
                            currentCustomer.getContas().add(conta);
                            banco.getContas().add(conta);
                            currentAccount = conta;
                        } else if (comando[1].equalsIgnoreCase("list")) {
                            System.out.println("Contas do cliente " + currentCustomer.getName());
                            currentCustomer.getContas().forEach(c -> System.out.println(c));
                        } else {
                            String id = comando[1];
                            currentAccount = currentCustomer.getContas().stream()
                                .filter(c -> c.getId().equals(id))
                                .findFirst()
                                .orElseThrow(() -> new BancoException("Conta não encontrada"));
                        }
                    }

                } else if (comando[0].equalsIgnoreCase("deposit")) {
                    if (currentAccount == null)
                        throw new BancoException("Conta não selecionada");
                    if (comando.length != 2)
                        throw new BancoException("Número de argumentos inválido");
                    double valor = Double.parseDouble(comando[1]);
                    currentAccount.depositar(valor);
                    System.out.println("Deposito efetuado com sucesso, saldo: " + currentAccount.getSaldo());

                } else if (comando[0].equalsIgnoreCase("withdraw")) {
                    if (currentAccount == null)
                        throw new BancoException("Conta não selecionada");
                    if (comando.length != 2)
                        throw new BancoException("Número de argumentos inválido");
                    double valor = Double.parseDouble(comando[1]);
                    currentAccount.sacar(valor);
                    System.out.println("Saque efetuado com sucesso, saldo: " + currentAccount.getSaldo());

                } else if (comando[0].equalsIgnoreCase("performance")) {

                    banco.getContas().stream()
                        .filter(c -> c instanceof Rendimento) // filtra
                        .map(c -> (Rendimento) c) // cast para ContaInvestimento
                        .forEach(Rendimento::aplicar);

                } else if (comando[0].equalsIgnoreCase("balance")) {
                    if (currentAccount == null) {
                        throw new BancoException("Conta não selecionada");
                    }
                    System.out.println("Saldo: " + currentAccount.getSaldo());

                } else {
                    throw new IllegalArgumentException("Comando inválido");
                }
            } catch (BancoException e) {
                e.printStackTrace();
                System.err.println("Excecao de negocio: " + e.getMessage());
            } catch (RuntimeException e) {
                e.printStackTrace();
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
        String tipo = readString("Tipo [F|J]: ", Set.of("F", "J", "f", "j"));
        String nome = readString("Nome: ", Set.of());
        String cpfCnpj = readString("CPF/CNPJ: ", Set.of());
        return "F".equalsIgnoreCase(tipo)
            ? new PessoaFisica(cpfCnpj, nome)
            : new PessoaJuridica(cpfCnpj, nome);
    }

    private static Conta createAccount(Cliente cliente) {
        String tipo = readString("Tipo [C|P|I]: ", Set.of("C", "P", "I", "c", "p", "i"));
        switch (tipo.toLowerCase()) {
            case "c": return new ContaCorrente();
            case "p": return new ContaPoupanca();
            case "i": return new ContaInvestimento();
        }
        throw new BancoException("Não foi possível criar a conta");
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
