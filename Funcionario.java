package trabalho;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner s = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Atualizar informações");
            System.out.println("4. Excluir funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar funcionário
                    System.out.print("Nome: ");
                    String nome = s.next();
                    System.out.print("Cargo: ");
                    String cargo = s.next();
                    System.out.print("Salário: ");
                    double salario = s.nextDouble();
                    System.out.print("Data de admissão (yyyy-MM-dd): ");
                    String dataAdmissaoStr = s.next();
                    Date dataAdmissao = java.sql.Date.valueOf(dataAdmissaoStr);
                    empresa.cadastrarFuncionario(nome, cargo, salario, dataAdmissao);
                    break;
                case 2:
                    // Listar funcionários
                    empresa.listarFuncionarios();
                    break;
                case 3:
                    // Atualizar informações
                    System.out.print("Nome do funcionário a ser atualizado: ");
                    String nomeAtualizar = s.next();
                    System.out.print("Novo cargo: ");
                    String novoCargo = s.next();
                    System.out.print("Novo salário: ");
                    double novoSalario = s.nextDouble();
                    empresa.atualizarInformacoes(nomeAtualizar, novoCargo, novoSalario);
                    break;
                case 4:
                    // Excluir funcionário
                    System.out.print("Nome do funcionário a ser excluído: ");
                    String nomeExcluir = s.next();
                    empresa.excluirFuncionario(nomeExcluir);
                    break;
                case 5:
                    // Sair
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        s.close();
    }
}
